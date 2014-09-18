package com.chat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Created by dell on 9/10/14.
 */
@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String message;
    @Column
    private long author_Id;
    @Column
    private long companion_Id;
    @Column
    private GregorianCalendar date;

    public Message(){}

    public Message(long author_Id, long companion_Id, String message, GregorianCalendar date){
        this.author_Id=author_Id;
        this.companion_Id=companion_Id;
        this.date=date;
        this.message=message;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getAuthorId() {
        return author_Id;
    }

    public void setAuthorId(long author_Id) {
        this.author_Id = author_Id;
    }

    public long getCompanionId() {
        return companion_Id;
    }

    public void setCompanionId(long companion_Id) {
        this.companion_Id = companion_Id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
