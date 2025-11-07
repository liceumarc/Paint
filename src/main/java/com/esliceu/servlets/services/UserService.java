package com.esliceu.servlets.services;

import com.esliceu.servlets.DAOS.UserDAO;
import com.esliceu.servlets.models.User;

public class UserService {
    public static User authenticateUser(String login, String password) {
        User user = UserDAO.USERS_MAP.get(login);

        if(user != null && user.checkPassword(password)){
            return user;
        }
        return null;
    }
}
