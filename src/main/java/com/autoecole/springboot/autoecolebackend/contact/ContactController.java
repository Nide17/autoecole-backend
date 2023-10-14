package com.autoecole.springboot.autoecolebackend.contact;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // THIS TELLS COMPILER THAT THIS IS A REST CONTROLLER THAT PERFORMS CRUD
                // OPERATIONS
@RequestMapping("/api/v1/contact") // THIS IS THE ROOT URL
@CrossOrigin(origins = "*") // THIS IS TO ALLOW CROSS ORIGIN REQUESTS
public class ContactController {

    // INJECT contactRepository WHICH GIVES US ACCESS TO CRUD OPERATIONS
    private final ContactRepository contactRepository;

    // CONSTRUCTOR INJECTION - INJECT contactRepository
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // MAPPING THE URL TO THE METHOD - GET ALL Contacts
    @GetMapping
    public List<Contact> getAllContacts() {

        // GET ALL CONTACTS FROM DATABASE
        return contactRepository.findAll();
    }

    // MAPPING THE URL TO THE METHOD - GET A CONTACT BY ID
    @GetMapping(path = "/{contactId}") // CHILD URL
    public Contact getContactById(@PathVariable("contactId") Long id) {

        // CHECK IF THE CONTACT EXISTS
        if (!contactRepository.existsById(id)) {
            // PRINT ERROR MESSAGE AND RETURN NULL
            System.out.println("That contact not found!");
            return null;
        }

        // ELSE RETURN THE CONTACT
        return contactRepository.findById(id).get();
    }

    // POST - CREATE A NEW CONTACT
    @PostMapping("")
    public Contact createContact(@RequestBody NewContactRequest request) throws IOException {
        // CREATE A NEW CONTACT
        Contact contact = new Contact();
        contact.setName(request.name);
        contact.setEmail(request.email);
        contact.setMessage(request.message);

        // SAVE THE NEW CONTACT TO DATABASE
        contactRepository.save(contact);

        // RETURN THE NEW CONTACT
        return contact;
    }

    // CREATE A NEW CONTACT REQUEST CLASS TO HOLD THE REQUEST DATA
    record NewContactRequest(String name, String email, String message) {
    }

    // DELETE - DELETE AN CONTACT
    @DeleteMapping("/{contactId}")
    public Contact deleteContact(@PathVariable("contactId") Long id) {
        contactRepository.deleteById(id);

        // RETURN THE DELETED CONTACT
        return contactRepository.findById(id).get();
    }

    // PUT - UPDATE AN CONTACT
    @PutMapping("/{contactId}")
    public Contact updateContact(
            @PathVariable("contactId") Long id,
            @RequestBody NewContactRequest request) {
        // GET THE CONTACT FROM DATABASE
        Contact contact = contactRepository.findById(id).get();

        // UPDATE THE CONTACT
        contact.setName(request.name);
        contact.setEmail(request.email);
        contact.setMessage(request.message);

        // SAVE THE UPDATED CONTACT TO DATABASE
        contactRepository.save(contact);

        // RETURN THE UPDATED CONTACT
        return contact;
    }
}
