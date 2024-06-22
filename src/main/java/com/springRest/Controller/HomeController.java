package com.springRest.Controller;

import com.springRest.enitity.Contact;
import com.springRest.enitity.Users;
import com.springRest.service.ContactService;
import com.springRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Home")
public class HomeController {

    @GetMapping("/home-page")
    public String getHomePage(Model model) {
        return "Home/home";
    }

    @GetMapping("/contact-US")
    public String getContactPage(Model model)
    {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact-US/contact-US";
    }

    @PostMapping("/save-contact")
    public String receiveContact(@ModelAttribute("contact") Contact contact) {
        // Logic to save contact information
        return "redirect:/Home/home-page";
    }
}
