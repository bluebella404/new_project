package com.usersite.controller;

import com.usersite.executor.DBException;
import com.usersite.executor.DBService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Михаил on 2017-05-02.
 */

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = -7283506683696024016L;
    private DBService dbservice;

    public UserServlet() {
        dbservice = new DBService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("users", dbservice.getAllUsers());
        } catch (DBException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }





    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


}

