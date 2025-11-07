package com.esliceu.servlets.DAOS;

import com.esliceu.servlets.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    public static final Map<String, User> USERS_MAP = new HashMap<>();

    static {
        USERS_MAP.put("testuser", new User("testuser", "Liceu2001@", "Usuario de Prueba"));
    }

    public static boolean registerUser(User user){
        String login = user.getLogin();
        if (USERS_MAP.containsKey(login)){
            return false;
        }
        USERS_MAP.put(login, user);
        return true;
    }

}
