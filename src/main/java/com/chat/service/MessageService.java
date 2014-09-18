package com.chat.service;

import com.chat.model.Message;

import java.util.List;

/**
 * Created by dell on 9/10/14.
 */
public interface MessageService{
    List<Message> findAll();

    void delete(long id);

    Message create(Message message);

    void update(Message message);
}
