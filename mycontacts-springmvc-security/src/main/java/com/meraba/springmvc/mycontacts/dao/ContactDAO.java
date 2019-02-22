package com.meraba.springmvc.mycontacts.dao;

import java.util.List;

import com.meraba.springmvc.mycontacts.entity.Contact;

public interface ContactDAO {
	
	public List<Contact> getContacts(String userName);
	
	public void saveContact(Contact theContact);
	
	public Contact getContact(int theId);
	
	public void deleteContact(int theId);
	
	public void saveUserDetail(int theId, String userName);
	
}
