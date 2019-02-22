package com.meraba.springmvc.mycontacts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="contacts_table")
public class Contact {
	
	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@NotNull(message="is required")
	@Size(min=1, max=50, message=" *invalid name")	
	private String firstName;

	
	@Column(name="last_name")
	@NotNull(message=" *is required")
	@Size(min=1, max=50, message=" *invalid surname")
	private String lastName;
	
	@Column(name="telephone")
	@Pattern(regexp="[0-9]+", message=" *only numbers")
	@Size(min=1, max=20, message=" *invalid telephone")
	private String telephone;

	public Contact() {}
	// generate getter/setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	// generate toString() : if we need, we can log it.
	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", telephone=" + telephone
				+ "]";
	}
}
