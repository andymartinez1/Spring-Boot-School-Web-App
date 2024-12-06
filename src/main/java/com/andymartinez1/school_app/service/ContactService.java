package com.andymartinez1.school_app.service;

import com.andymartinez1.school_app.controller.ContactController;
import com.andymartinez1.school_app.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private static Logger log = LoggerFactory.getLogger(ContactService.class);

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;

        log.info(contact.toString());
        return isSaved;
    }
}
