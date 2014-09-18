package com.chat.service.impl;

import com.chat.dao.UserDao;
import com.chat.model.User;
import com.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dell on 9/11/14.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserDao resource;

    @Override
    @Transactional
    public List<User> findAll() {
        return resource.findAll();
    }

    @Override
    @Transactional
    public void delete(long id) {
        resource.delete(id);
    }

    @Override
    @Transactional
    public User create(User user) {
        resource.create(user);
        return user;
    }

    @Override
    @Transactional
    public void update(User user) {
        resource.update(user);
    }

    @Override
    @Transactional
    public User findByLogin(String login) {
        return resource.findByLogin(login);
    }
}
