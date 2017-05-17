package com.usersite.dao;

import com.usersite.models.User;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by Михаил on 2017-04-29.
 */



public interface UserDaoI {

    List getAllUsers() throws HibernateException;

    void addUser(User user) throws HibernateException;

    void update(Class type, int id, String username, String password, String role) throws HibernateException;

    boolean deleteUser(Class type, int id) throws HibernateException;

}
