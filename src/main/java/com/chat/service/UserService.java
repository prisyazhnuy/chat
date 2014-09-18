package com.chat.service;

import com.chat.model.Message;
import com.chat.model.User;

import java.util.List;

/**
 * Created by dell on 9/11/14.
 */
public interface UserService{
    List<User> findAll();

    void delete(long id);

    User create(User user);

    void update(User user);

    User findByLogin(String login);
}
