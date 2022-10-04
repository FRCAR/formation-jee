package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactData {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String address;
	private String email;
	private String phone1;
	private String phone2;

	public ContactData() {
	}

	public ContactData(String address, String email, String phone1, String phone2) {
		super();
		this.address = address;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

}
