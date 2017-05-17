package com.usersite.controller;

import com.usersite.dao.UserDaoImp;
import com.usersite.models.User;
import org.hibernate.HibernateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Михаил on 2017-05-11.
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    private static final long serialVersionUID = -1326518095963058522L;
    private static final Class type = User.class;
    private UserDaoImp dao;

    public EditServlet() {
        dao = new UserDaoImp();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            request.setAttribute("user", dao.get(type, id));
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/edit.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");



        try {
            dao.update(type, id, username, password, role);
        } catch (HibernateException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/user");

    }

}
