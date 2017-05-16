package com.usersite.dao;

import com.usersite.models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Михаил on 2017-05-02.
 */
public class UserDaoImp implements UserDaoI {


    private Session session;

    public UserDaoImp(Session session) {
        this.session = session;
    }

    public User get(Class type, Integer id){
        return (User) session.get(type, id);
    }


    public List<User> getAllUsers(Class type) throws HibernateException {
        Criteria criteria = session.createCriteria(type);
        return criteria.list();
    }

    public void addUser(User user) throws HibernateException {
            session.save(user);
        }


    public void update(Class type, int id, String username, String password, String role) throws HibernateException {
        User user = (User) session.get(type, id);
        user.setUsername(username);
        user.setRole(role);
        user.setPassword(password);
        session.update(user);

    }

    public boolean deleteUser(Class type,int id) throws HibernateException {
        Object persistentInstance = session.load(type, id);
        if (persistentInstance != null) {
            session.delete(persistentInstance);
            return true;
        }
        return false;
    }


}
