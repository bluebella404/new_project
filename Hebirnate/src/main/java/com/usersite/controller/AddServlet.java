package com.usersite.controller;

import com.usersite.executor.DBException;
import com.usersite.executor.DBService;
import com.usersite.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Михаил on 2017-05-09.
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {

    private DBService dbservice;

    public AddServlet() {
        dbservice = new DBService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");


        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        try {
            dbservice.addUser(user);
        } catch (DBException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/user");
    }


    }

