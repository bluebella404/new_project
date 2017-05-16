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
 * Created by Михаил on 2017-05-11.
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    private static final long serialVersionUID = -1326518095963058522L;
    private DBService dbservice;

    public EditServlet() {
        dbservice = new DBService();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            request.setAttribute("user", dbservice.getUser(id));
        } catch (DBException e) {
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


        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        try {
            dbservice.updateUser(id, username, password, role);
        } catch (DBException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/user");

    }

}
