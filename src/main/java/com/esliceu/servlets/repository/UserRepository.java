package com.esliceu.servlets.repository;

import com.esliceu.servlets.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<String, User> USERS_MAP = new HashMap<>();

    public static boolean registerUser(User user){
        String login = user.getLogin();
        if (USERS_MAP.containsKey(login)){
            return false;
        }
        USERS_MAP.put(login, user);
        return true;
    }

    public static User authenticateUser(String login, String password) {
        User user = USERS_MAP.get(login);

        if(user != null && user.checkPassword(password)){
            return user;
        }
        return null;
    }
}
