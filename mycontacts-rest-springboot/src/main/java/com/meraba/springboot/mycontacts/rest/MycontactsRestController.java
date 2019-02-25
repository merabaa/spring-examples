package com.meraba.springboot.mycontacts.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meraba.springboot.mycontacts.entity.Contact;
import com.meraba.springboot.mycontacts.service.ContactService;

 
@RestController
@RequestMapping("/api")
public class MycontactsRestController {
	
	private ContactService contactService;
	 
	@Autowired
	public MycontactsRestController(ContactService theContactService)
	{
		contactService = theContactService;
	}
	
	// expose "/contacts" and return list of contacts
	@GetMapping("/contacts")
	public List<Contact> findAll()
	{
		return contactService.findAll();
	}
	
	// add mapping for GET /contacts/{contactId}
	
	@GetMapping("/contacts/{contactId}")
	public Contact getContact(@PathVariable int contactId)
	{
		
		Contact theContact = contactService.findById(contactId);
		
		if(theContact == null)
		{
			throw new RuntimeException("Contact id not found - " + contactId);
			
		}
		
		return theContact;
		
	}
	
	// add mapping for POST /contacts - add new contact
	
	@PostMapping("/contacts")
	public Contact addContact(@RequestBody Contact theContact) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to forces a save of new item ... instead update
		
		theContact.setId(0);
		
		contactService.save(theContact);
		return theContact; // returning as a json thx to spring and jackson
		
	}
	
	// add mapping for PUT /contacts - update existing contact
	@PutMapping("/contacts")
	public Contact updateContact(@RequestBody Contact theContact)
	{
		contactService.save(theContact);
		
		return theContact;
	}
	
	// add mapping for DELETE /contacts/{contactId} - delete contact
	
	@DeleteMapping("/contacts/{contactId}")
	public String deleteContact(@PathVariable int contactId)
	{
		Contact tempContact = contactService.findById(contactId);
		//throw exception if null
		
		if(tempContact == null) {
			throw new RuntimeException("Contact id not found - " + contactId);
		
		}
		contactService.deleteById(contactId);
		return "Deleted contact id : " + contactId;
	}
	
}
