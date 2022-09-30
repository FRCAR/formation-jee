package com.bigcorp.booking.faces.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class RestaurantFormBean implements Serializable {
	
	public static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Boolean active;
	private String address;
	private String phone;
	private String email;
	private Long restaurantTypeId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRestaurantTypeId() {
		return restaurantTypeId;
	}

	public void setRestaurantTypeId(Long restaurantTypeId) {
		this.restaurantTypeId = restaurantTypeId;
	}

	
}