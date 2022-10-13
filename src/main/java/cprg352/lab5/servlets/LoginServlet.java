package cprg352.lab5.servlets;

import cprg352.lab5.models.User;
import cprg352.lab5.services.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String logout = request.getParameter("logout");
        if (logout != null) {
            session.invalidate();
            request.setAttribute("message", "You have been successfully logged out!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        String username = (String) session.getAttribute("username");
        if (username != null) {
            response.sendRedirect("home");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        AccountService as = new AccountService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //check if username and password are valid
        if (username != null && password != null && !username.equals("") && !password.equals("")) {
            User user = as.login(username, password);
            if (user != null) {
                session.setAttribute("username", username);
                response.sendRedirect("home");
            } else {
                request.setAttribute("message", "Invalid username or password");
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Missing username or password");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
