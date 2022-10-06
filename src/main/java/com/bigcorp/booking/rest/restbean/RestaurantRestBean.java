package com.bigcorp.booking.rest.restbean;

import javax.validation.constraints.Email;

public class RestaurantRestBean {

	private Long id;

	private String name;

	private Boolean active;
	private String address;
	private String phone;
	@Email
	private String email;
	private Long restaurantTypeId;

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public String getAddress() {
		return address;
	}

}