package com.esliceu.servlets.controllers;

import com.esliceu.servlets.DAOS.UserDAO;
import com.esliceu.servlets.models.User;
import com.esliceu.servlets.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        System.out.println("User: " + login);

        // Aquesta funció l'ha de fer el servei
        User user = UserService.authenticateUser(login, password);

        if(user != null){
            req.getSession().setAttribute("currentUser", user.getLogin());
            resp.sendRedirect("/paint");
        } else {
            req.setAttribute("error", "Error: Login o contraseña incorrectos.");
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        }
    }
}
