package com.meraba.springmvc.mycontacts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meraba.springmvc.mycontacts.entity.Contact;
import com.meraba.springmvc.mycontacts.service.ContactService;

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
		//------- Get Current User Name ---
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String userName="";
				if (principal instanceof UserDetails) {
					userName = ((UserDetails)principal).getUsername();
				} else {
					userName = principal.toString();
				}
		//-------
		
		//get contacts from the service
		List<Contact> theContacts = contactService.getContacts(userName);
		
		// add the contacts to the model
		theModel.addAttribute("contacts", theContacts);
		
		return "list-contacts";
	}
	
	// add form
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) 
	{
		// create model attribute to bind form data
		Contact theContact = new Contact();
		
		// add attributes to model
		theModel.addAttribute("contact", theContact);
		
		// return contact-form.jsp
		return "contact-form";		
	}
	
	// save contact
	
	@PostMapping("/saveContact") // contact form.jsp's, form action is "saveContact"
	public String saveContact(@Valid @ModelAttribute("contact") Contact theContact,
			BindingResult theBindingResult ) {
		
		if(theBindingResult.hasErrors()) {

			return "contact-form";
		}
		
		// save the contact using service
		contactService.saveContact(theContact);
		
		int theId=theContact.getId();
		//------- Get Current User Name --
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String userName="u";
				if (principal instanceof UserDetails) {
					userName = ((UserDetails)principal).getUsername();
				} else {
					userName = principal.toString();
				}
		//-------
		
		contactService.saveUserDetail(theId, userName);
		
		// redirect to list page
		return "redirect:/contact/list";		
	}
	
	// update contact
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("contactId") int theId,
																	Model theModel)
	{
		// get contact from service
		Contact theContact = contactService.getContact(theId);
		
		// set contact as a model attribute to pre-populate the form
		theModel.addAttribute("contact", theContact);
		// send over to form
		return "contact-form";		
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("contactId") int theId)
	{
		// delete the contact
		contactService.deleteContact(theId);
		
		// after deleting, return list page
		return "redirect:/contact/list";
	}
}
