<%--
  Created by IntelliJ IDEA.
  User: Bennett
  Date: 06-Oct-22
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login JSP</title>
</head>
<body>
<h1>Login</h1>
    <form action="login" method="post">
        <div>
            <label>Username: </label>
            <input type="text" name="username" value="${username}"/>
        </div>
        <div>
            <label>Password: </label>
            <input type="password" name="password" value="${password}"/>
        </div>
        <div>
            <input type="submit" value="Log in">
        </div>
    </form>

    <p>${message}</p>
</body>
</html>
