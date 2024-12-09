package com.andymartinez1.school_app.service;

import org.springframework.stereotype.Service;

import com.andymartinez1.school_app.model.Contact;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactService {

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;

        log.info(contact.toString());
        return isSaved;
    }
}
