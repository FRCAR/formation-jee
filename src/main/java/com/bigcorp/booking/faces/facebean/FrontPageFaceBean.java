package com.bigcorp.booking.faces.facebean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bigcorp.booking.model.RestaurantType;
import com.bigcorp.booking.service.RestaurantTypeService;

@Named
@RequestScoped
public class FrontPageFaceBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected RestaurantTypeService restaurantTypeService;

	private String restaurantTypeFilter;

	private List<RestaurantType> restaurantTypes = null;

	public String getRestaurantTypeFilter() {
		return restaurantTypeFilter;
	}

	public void setRestaurantTypeFilter(String restaurantTypeFilter) {
		this.restaurantTypeFilter = restaurantTypeFilter;
		this.restaurantTypes = null;
	}

	public List<RestaurantType> getRestaurantTypes() {
		this.restaurantTypes = this.restaurantTypeService.findLikeName(this.restaurantTypeFilter);
		return this.restaurantTypes;
	}

	public void setRestaurantTypes(List<RestaurantType> restaurantTypes) {
	}

}