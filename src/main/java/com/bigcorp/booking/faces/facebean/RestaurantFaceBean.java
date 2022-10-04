package com.bigcorp.booking.faces.facebean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bigcorp.booking.faces.formbean.RestaurantFormBean;
import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.service.RestaurantService;
import com.bigcorp.booking.service.RestaurantTypeService;

@Named
@RequestScoped
public class RestaurantFaceBean {
	
	@Inject
	protected RestaurantTypeService restaurantTypeService;
	
	@Inject
	protected RestaurantService restaurantService;

	@Inject
	protected RestaurantFormBean restaurantFormBean;
	
	private String loadId;

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public String displayCreate() {
		return "restaurant?faces-redirect=true";
	}

	public String save() {
		Restaurant restaurantEntity = toEntity();
		restaurantEntity = this.restaurantService.save(restaurantEntity);
		this.restaurantFormBean.setId(restaurantEntity.getId());
		return this.restaurantFormBean.getId() == null ? "restaurant?faces-redirect=true"
				: "restaurant?id=" + this.restaurantFormBean.getId() + "&faces-redirect=true";
	}

	public void onLoad() {
		if(this.loadId == null) {
			return;
		}
		long loadIdAsLong = 0;
		try {
			loadIdAsLong = Long.parseLong(loadId);			
		}catch(NumberFormatException nfe) {
			return;
		}
		Restaurant restaurant = this.restaurantService.findById(loadIdAsLong);
		if(restaurant == null) {
			return;
		}
		toFormBean(restaurant);
	}
	
	private void toFormBean(Restaurant restaurant) {
		this.restaurantFormBean.setName(restaurant.getName());
		this.restaurantFormBean.setAddress(restaurant.getAddress());
		this.restaurantFormBean.setEmail(restaurant.getEmail());
		this.restaurantFormBean.setPhone(restaurant.getPhone());
		this.restaurantFormBean.setActive(restaurant.getActive());
		if(restaurant.getRestaurantType() == null) {
			this.restaurantFormBean.setRestaurantTypeId(null);
		}else {
			this.restaurantFormBean.setRestaurantTypeId(restaurant.getRestaurantType().getId());
		}
		
	}
	
	private Restaurant toEntity() {
		Restaurant restaurant = new Restaurant();
		restaurant.setId(this.restaurantFormBean.getId());
		restaurant.setName(this.restaurantFormBean.getName());
		restaurant.setAddress(this.restaurantFormBean.getAddress());
		restaurant.setEmail(this.restaurantFormBean.getEmail());
		restaurant.setPhone(this.restaurantFormBean.getPhone());
		restaurant.setActive(this.restaurantFormBean.getActive());
		restaurant.setRestaurantType(this.restaurantTypeService.findById(this.restaurantFormBean.getRestaurantTypeId()));
		return restaurant;
	}

}
