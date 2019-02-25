package com.meraba.springboot.mycontacts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact_detail")
public class ContactDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	@Column(name="second_phone")
	private String secondPhone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="notes")
	private String notes;
	
	@OneToOne(mappedBy="contactDetail",
			cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Contact contact;
	
	// default constructor
	public ContactDetail() {}
	// constructor with fields
	public ContactDetail(String secondPhone, String address, String email, String notes) {
		this.secondPhone = secondPhone;
		this.address = address;
		this.email = email;
		this.notes = notes;
	}
	
	
	
	// getter/setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSecondPhone() {
		return secondPhone;
	}
	public void setSecondPhone(String secondPhone) {
		this.secondPhone = secondPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	//------
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	//-------
	
	
	@Override
	public String toString() {
		return "ContactDetail [id=" + id + ", secondPhone=" + secondPhone + ", address=" + address + ", email=" + email
				+ ", notes=" + notes + "]";
	}
	
	
	
	
	
	
}
