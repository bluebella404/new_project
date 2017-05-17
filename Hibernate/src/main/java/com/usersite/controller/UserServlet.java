package com.usersite.controller;

import com.usersite.dao.UserDaoImp;
import org.hibernate.HibernateException;


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
    private UserDaoImp dao;

    public UserServlet() {
        dao = new UserDaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("users", dao.getAllUsers());
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }





    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


}

