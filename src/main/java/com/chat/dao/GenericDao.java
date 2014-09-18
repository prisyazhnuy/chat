package com.chat.dao;

import java.util.Collection;
import java.util.List;

/**
 * Created by dell on 9/11/14.
 */
public interface GenericDao<T> {

    T create(T t);

    void delete(long id);

    T update(T t);

    List<T> findAll();

}
