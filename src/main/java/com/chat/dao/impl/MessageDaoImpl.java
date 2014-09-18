package com.chat.dao.impl;

import com.chat.dao.GenericDao;
import com.chat.dao.MessageDao;
import com.chat.model.Message;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 9/10/14.
 */
@Repository
public class MessageDaoImpl extends GenericDaoImpl<Message> implements MessageDao {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }


}
