package com.meraba.springboot.mycontacts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meraba.springboot.mycontacts.dao.ContactRepository;
import com.meraba.springboot.mycontacts.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepository;
	
	
	@Autowired
	public ContactServiceImpl(ContactRepository theContactRepository) {
		contactRepository = theContactRepository;
		
	}
	
	@Override
	public List<Contact> findAll() {
		 

		return contactRepository.findAll();
	}

	@Override
	public Contact findById(int theId) {
		Optional<Contact> result = contactRepository.findById(theId);
		
		Contact theContact = null;
		if(result.isPresent()) { // Java 8 feature (Optional<> also Java8 feature)
			theContact = result.get(); 
		}else {
			throw new RuntimeException("Did not find contact id - " + theId);
			
		}
		
		return theContact;
	}

	@Override
	public void save(Contact theContact) {
		 contactRepository.save(theContact);
		
	}

	@Override
	public void deleteById(int theId) {
		contactRepository.deleteById(theId);
		
	}	
	 
}
