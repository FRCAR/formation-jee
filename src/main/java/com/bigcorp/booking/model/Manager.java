package com.bigcorp.booking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOKING_MANAGER")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String name;

	@ManyToMany(mappedBy = "managers")
	private Set<Restaurant> restaurants = new HashSet<>();

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(
	    	name="CONTACT_DATA", unique=true, nullable=false, updatable=false)
	private ContactData contactData = new ContactData();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public ContactData getContactData() {
		return contactData;
	}

	public void setContactData(ContactData contactData) {
		this.contactData = contactData;
	}
	
	
	
	

}
