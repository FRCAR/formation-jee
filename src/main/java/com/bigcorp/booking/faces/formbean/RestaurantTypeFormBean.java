package com.bigcorp.booking.faces.formbean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;

@Named
@ViewScoped
public class RestaurantTypeFormBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank
	private String name;
	
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
	
}