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
 * Created by Михаил on 2017-05-09.
 */

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 2120551907856423478L;
    private UserDaoImp dao;

    public DeleteServlet() {
        dao = new UserDaoImp();
    }
////// почему doGet???
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            dao.deleteUser(User.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/user");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
