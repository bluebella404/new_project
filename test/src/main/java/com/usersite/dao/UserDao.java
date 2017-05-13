package com.usersite.dao;

import com.usersite.dbpackage.ConnectionProvider;
import com.usersite.executor.Executor;
import com.usersite.models.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Михаил on 2017-05-02.
 */
public class UserDao implements UserDaoI {

    private Executor executor;
    private Connection conn;

    public UserDao() {
        conn = ConnectionProvider.getConnection();
        this.executor = new Executor(conn);
    }

    public User get(int id) throws SQLException {
        return executor.execQuery("select id, username, password, role from users where id=" + id, result -> {
            result.next();
            return new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
        });
    }



    public List<User> getAllUsers() throws SQLException {

        return executor.execQuery("select * from users ", result -> {
            List<User> users = null;
            while (result.next()) {
                users = new ArrayList<>();
                users.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
            }
            return users;
        });
    }

    public void addUser(User user) throws  SQLException {
        executor.execUpdate("insert into users (username, password, role) values ('" + user.getUsername()+ "','" + user.getPassword() + "','" + user.getRole() +"')");
    }

    public void update(User user) throws SQLException {
        executor.execUpdate("update users SET username='" + user.getUsername()+ "',password='" + user.getPassword()+ "',role='" + user.getRole()+ "' where id='" + user.getId() + "'");
    }

    public void deleteUser(int id) throws SQLException {
        executor.execUpdate("delete from users where id='" + id + "'");
    }

    public long getUserId(String name) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + name + "'", result -> {
            result.next();
            return result.getLong(1);
        });
    }


    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, user_name varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }


}
