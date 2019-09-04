package com.meraba.springmvc.mycontacts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meraba.springmvc.mycontacts.entity.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	// inject the session factory from hibernate
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Contact> getContacts(String userName) {
		 
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a hibernate query, sort by last name.
		Query<Contact> theQuery = 
				currentSession.createQuery("from Contact where username=:userName order by firstName",
						Contact.class);
		theQuery.setParameter("userName", userName);
		// execute query and get result list
		List<Contact> contacts = theQuery.getResultList();
		
		// return the results
		
		return contacts;
	}

	@Override
	public void saveContact(Contact theContact) {
		 
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the contact
		currentSession.saveOrUpdate(theContact);
	}

	@Override
	public Contact getContact(int theId) {
		 
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using the primary key
		Contact theContact = currentSession.get(Contact.class, theId);
		return theContact;
	}

	@Override
	public void deleteContact(int theId) {
		 
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		 
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Contact where id=:contactId");
		theQuery.setParameter("contactId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public void saveUserDetail(int theId, String userName) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// update object with primary key
		Query theQuery = 
			currentSession.createQuery("update Contact set username=:userName where id=:contactId");
		theQuery.setParameter("userName", userName);
		theQuery.setParameter("contactId", theId);
				
		theQuery.executeUpdate();

	}

}
