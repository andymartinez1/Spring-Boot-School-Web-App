package com.andymartinez1.school_app.controller;

import com.andymartinez1.school_app.model.Contact;
import com.andymartinez1.school_app.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.ApplicationScope;

@Slf4j
@Controller
@ApplicationScope
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Created a separate contact controller rather than config as it is more
    // complex
    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact,
                              Errors errors) {
        if (errors.hasErrors()) {
            log.error("Contact form validation has failed due to :" + errors);
            return "contact.html";
        }

        contactService.saveMessageDetails(contact);
        contactService.setCounter(contactService.getCounter() + 1);
        log.info("Number of times the Contact form is submitted : " + contactService.getCounter());
        return ("redirect:/contact");
    }

}
