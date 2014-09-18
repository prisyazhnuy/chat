package com.chat.dao.impl;

import com.chat.dao.UserDao;
import com.chat.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.beans.Expression;

/**
 * Created by dell on 9/11/14.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    @Override
    public User findByLogin(String login) {
        return (User)getCurrentSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
    }
}
