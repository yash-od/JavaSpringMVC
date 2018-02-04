package com.controller;
import com.model.Contact;
import com.model.ContactDao;
import com.model.ContactDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;

/**
 * Created by yashjain on 1/17/18.
 */

@Controller
public class ContactController {

    @Autowired
    ContactDaoImpl dao;

    @RequestMapping("/contact")
    public ModelAndView getContact(){
        ModelAndView model = new ModelAndView("ContactForm");
        model.addObject("welcomemsg","ContactList");
        return model;
    }

    @RequestMapping("/view")
    public ModelAndView showList(){

        // iew all contacts
        List<Contact> contactlist = dao.fetchData();

        for(Contact ob1:contactlist){
           System.out.println(ob1.getName());
        }
        ModelAndView model = new ModelAndView("viewlist");
        model.addObject("conctlist",contactlist.toString());
        return  model;
    }

    @RequestMapping(value = "/SpringMVC/SubmitContactForm.html" , method = RequestMethod.POST)
    public ModelAndView SubmitContact(@RequestParam("contactname") String name, @RequestParam("contactno") String contactno){

        dao.insertData(new Contact(14,name,contactno));
        ModelAndView model = new ModelAndView("ContactSuccess");
        model.addObject("msg","Inserted successfully");
        return model;
    }

}
