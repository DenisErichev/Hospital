package com.springRest.Controller;


import com.springRest.enitity.Contact;
import com.springRest.enitity.Disease;
import com.springRest.enitity.Medicine;
import com.springRest.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact-US")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @GetMapping("/addContact")
    public String getmedicineForm(Model model)
    {
        Contact theContact = new Contact();
        model.addAttribute("contact",theContact);
        return "contact-US/addContact";
    }
    @PostMapping("/save")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.save(contact);
        return "redirect:/Home";
    }
    @GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("contactId") int theID,Model model)
    {
        model.addAttribute("contact",contactService.findById(theID));
        return "contact-US/contact-US";
    }
    @GetMapping("/contact-US")
    public String getContactForm(Model model)
    {
        Contact contact = new Contact();
        model.addAttribute("contact",contact);
        return "contact-US/contact-US";
    }

}
