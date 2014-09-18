package com.chat.dao;

import com.chat.model.User;

/**
 * Created by dell on 9/11/14.
 */
public interface UserDao extends GenericDao<User> {
    User findByLogin(String login);
}
