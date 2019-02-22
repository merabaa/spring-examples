package com.meraba.springmvc.mycontacts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meraba.springmvc.mycontacts.dao.ContactDAO;
import com.meraba.springmvc.mycontacts.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {	
	// inject contactDao interface
	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	@Transactional
	public List<Contact> getContacts(String userName) {
		
		return contactDAO.getContacts(userName);
	}

	@Override
	@Transactional
	public void saveContact(Contact theContact) {
		 contactDAO.saveContact(theContact);
	}

	@Override
	@Transactional
	public Contact getContact(int theId) {
		 
		return contactDAO.getContact(theId);
	}

	@Override
	@Transactional
	public void deleteContact(int theId) {
		 contactDAO.deleteContact(theId);

	}

	@Override
	@Transactional
	public void saveUserDetail(int theId, String userName) {
		contactDAO.saveUserDetail(theId, userName);
	}

}
