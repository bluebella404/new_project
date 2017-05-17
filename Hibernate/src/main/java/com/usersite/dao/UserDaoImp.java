package com.usersite.dao;

import com.usersite.executor.DBService;
import com.usersite.models.User;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created by Михаил on 2017-05-02.
 */
public class UserDaoImp implements UserDaoI {


    private final SessionFactory sessionFactory;

    public UserDaoImp() {
        sessionFactory = createSessionFactory(DBService.getInstance().getConfiguration());
    }

    public User get(Class type, Integer id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(type, id);
        transaction.commit();
        session.close();
        return user;
    }


    public List<User> getAllUsers() throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List users = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return users;

    }

    public void addUser(User user) throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        }


    public void update(Class type, int id, String username, String password, String role) throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(type, id);
        user.setUsername(username);
        user.setRole(role);
        user.setPassword(password);
        session.update(user);
        transaction.commit();
        session.close();

    }

    public boolean deleteUser(Class type,int id) throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Object persistentInstance = session.load(type, id);
        if (persistentInstance != null) {
            session.delete(persistentInstance);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
