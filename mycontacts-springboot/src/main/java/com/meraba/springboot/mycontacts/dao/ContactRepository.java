package com.meraba.springboot.mycontacts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meraba.springboot.mycontacts.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> { 
	// Contact : entity type, Integer: primary key type
 
}
