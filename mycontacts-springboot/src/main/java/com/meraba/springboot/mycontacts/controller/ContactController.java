package com.meraba.springboot.mycontacts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meraba.springboot.mycontacts.entity.Contact;
import com.meraba.springboot.mycontacts.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	// inject contact service
	@Autowired
	private ContactService contactService;
	
	// list page 
	@GetMapping("/list")
	public String listContacts(Model theModel)
	{
		//get contacts from the service
		List<Contact> theContacts = contactService.findAll();
		
		// add the contact to the model
		theModel.addAttribute("contacts", theContacts);
				
		return "list-contacts";
		
	}
	
	// add form
	
	@GetMapping("/showFormForAdd") // contact-form
	public String showFormForAdd(ModelMap theModel) 
	{
		// create model attribute to bind form data
		Contact theContact = new Contact();
		
		// add attributes to model
		theModel.addAttribute("contact", theContact);
		
		// return contact-form.jsp
		return "contact-form";
		
	}
	
	// update contact
	
	@GetMapping("/showFormForUpdate") // contact-form 
	public String showFormForUpdate(@RequestParam("contactId") int theId,
																	Model theModel)
	{
		// get contact from service
		Contact theContact = contactService.findById(theId);
		 
		// set contact as a model attribute to pre-populate the form
		theModel.addAttribute("contact", theContact);
		
		// send over to form
		return "contact-form";		
	}	
	
	
	@PostMapping("/saveContact") // contact form.jsp's, form action is "saveContact"
	public String saveContact(@Valid @ModelAttribute("contact") Contact theContact,
			BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {

			return "contact-form";
		}
 
		// save the contact using service
		contactService.save(theContact);

		// redirect to list page
		return "redirect:/contact/list"; 	
	}
	
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("contactId") int theId)
	{
		// delete the contact
		contactService.deleteById(theId);
		
		// after deleting, return list page
		return "redirect:/contact/list";
	}

}
