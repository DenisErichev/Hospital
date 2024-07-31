package com.springRest.service;

import com.springRest.DAO.ContactRepository;
import com.springRest.enitity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {
    private ContactRepository contactRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository)
    {
        this.contactRepository = contactRepository;
    }
    public Contact findById(int id) {
        Contact contact =null;
        Optional<Contact> disease = contactRepository.findById(id);
        if(disease.isPresent())
        {
            contact = disease.get();
        }
        return contact;
    }
    public void save(Contact contact)
    {
        contactRepository.save(contact);
    }

}
