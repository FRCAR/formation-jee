package com.bigcorp.booking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String name;

	private String address;

	private String email;

	private String phone;

	private Boolean active;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "RESTAURANT_TYPE_ID")
	private RestaurantType restaurantType;

	@ManyToMany
	@JoinTable(name = "RESTAURANT_MANAGER", joinColumns = @JoinColumn(name = "RESTAURANT_ID"), inverseJoinColumns = @JoinColumn(name = "MANAGER_ID"))
	private Set<Manager> managers = new HashSet<>();

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

	public RestaurantType getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(RestaurantType restaurantType) {
		this.restaurantType = restaurantType;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Manager> getManagers() {
		return managers;
	}

	public void setManagers(Set<Manager> managers) {
		this.managers = managers;
	}

	/**
	 * Associates this with manager (fills this.managers and managers.restaurants)
	 * 
	 * @param manager
	 */
	public void associateWith(Manager manager) {
		if (manager == null) {
			return;
		}
		this.managers.add(manager);
		manager.getRestaurants().add(this);
	}

	/**
	 * Sets this.restaurantType and adds this to
	 * restaurantType.restaurants
	 * 
	 * @param restaurantType
	 */
	public void associateWith(RestaurantType restaurantType) {
		setRestaurantType(restaurantType);
		if (this.restaurantType != null) {
			this.restaurantType.getRestaurants().add(this);
		}
	}

}
