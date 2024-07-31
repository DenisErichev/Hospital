package com.springRest.Controller;


import com.springRest.enitity.Contact;
import com.springRest.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("contact") Contact contact) {
        contactService.save(contact);
        return "redirect:/";
    }

}
