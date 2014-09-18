package com.chat.service.impl;

import com.chat.dao.MessageDao;
import com.chat.model.Message;
import com.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dell on 9/10/14.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    protected MessageDao resource;

    @Override
    @Transactional
    public List<Message> findAll() {
        return resource.findAll();
    }

    @Override
    @Transactional
    public void delete(long id) {
        resource.delete(id);
    }

    @Override
    @Transactional
    public Message create(Message message) {
        resource.create(message);
        return message;
    }

    @Override
    @Transactional
    public void update(Message message) {
        resource.update(message);
    }
}
