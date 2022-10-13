package cprg352.lab5.services;

import cprg352.lab5.models.User;

public class AccountService {
    public User login(String username, String password) {
        if ((username.equals("adam") || username.equals("betty")) && password.equals("password"))
            return new User(username, null);

        return null;
    }
}

