package com.esliceu.servlets.controllers;

import com.esliceu.servlets.models.User;
import com.esliceu.servlets.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/Register")
public class Register extends HttpServlet {

    private static final String REGEX_PASSWORD =  "^(?=.*[0-9])(?=.*[@$!%*#?&])\\S{8,}$";
    private static final Pattern PATTERN = Pattern.compile(REGEX_PASSWORD);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String message = "";

        if (!isValid(password)){
            message = "Error: La contraseña debe tener al menos 8 caracteres, una mayuscula y un caracter especial. ";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
        }

        User newUser = new User(login, password, name);
        boolean success = UserRepository.registerUser(newUser);

        if (success){
            /* Registro existoso, inciar sesión automaticamente
            req.getSession().setAttribute("currentUser", login);
            resp.sendRedirect("paint.jsp");
             */
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        } else {
            message = "Error: El login: " + login + " ya está en uso.";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
        }
    }

    private static boolean isValid(String password){
        if (password == null){
            return false;
        }
        Matcher matcher = PATTERN.matcher(password);
        return matcher.matches();
    }

}
