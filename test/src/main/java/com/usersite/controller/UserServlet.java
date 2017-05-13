package com.usersite.controller;

import com.usersite.dao.UserDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Михаил on 2017-05-02.
 */

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserDao dao;

    public UserServlet() {
        super();
        dao= new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("users", dao.getAllUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }





    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


}

