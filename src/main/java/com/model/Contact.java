package com.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by yashjain on 1/17/18.
 */
@Component
public class Contact {
    private int id;
    private  String contactno;
    private String name;

    public Contact() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact(int id, String contactno, String name){
        setContactno(contactno);
        setId(id);
        setName(name);
    }

    @Override
    public String toString() {
        return super.toString() + this.id + this.contactno + this.name;
    }
}
