package com.model;

import java.util.List;

/**
 * Created by yashjain on 1/17/18.
 */
public interface ContactDao {

    //inserts data
    public void insertData(Contact contact);

    // fetches all data.
    public List<Contact> fetchData();
}
