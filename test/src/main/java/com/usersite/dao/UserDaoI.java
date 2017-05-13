package com.usersite.dao;

import com.usersite.models.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Михаил on 2017-04-29.
 */



public interface UserDaoI {

    List<User> getAllUsers() throws SQLException;

    void addUser(User user) throws SQLException;

    void update(User user) throws SQLException;

    void deleteUser(int id) throws SQLException;

}
