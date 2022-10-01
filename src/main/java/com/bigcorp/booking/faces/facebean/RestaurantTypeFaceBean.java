package com.bigcorp.booking.faces.facebean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bigcorp.booking.faces.formbean.RestaurantTypeFormBean;
import com.bigcorp.booking.model.RestaurantType;
import com.bigcorp.booking.service.RestaurantTypeService;

@Named
@RequestScoped
public class RestaurantTypeFaceBean {

	@Inject
	protected RestaurantTypeService restaurantTypeService;

	@Inject
	protected RestaurantTypeFormBean restaurantTypeFormBean;
	
	private String loadId;

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public String displayCreate() {
		return "restaurant-type?faces-redirect=true";
	}

	public String displayAll() {
		return "restaurant-type-array?faces-redirect=true";
	}

	public String load() {
		return "restaurant-type-array?faces-redirect=true";
	}

	public List<RestaurantType> getAllTypes() {
		return restaurantTypeService.findAll();
	}

	public String save() {
		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setId(this.restaurantTypeFormBean.getId());
		restaurantType.setName(this.restaurantTypeFormBean.getName());
		RestaurantType persistedRestaurantType = this.restaurantTypeService.save(restaurantType);
		this.restaurantTypeFormBean.setId(persistedRestaurantType.getId());
		this.restaurantTypeFormBean.setName(persistedRestaurantType.getName());
		return this.restaurantTypeFormBean.getId() == null ? "restaurant-type?faces-redirect=true"
				: "restaurant-type?id=" + this.restaurantTypeFormBean.getId() + "&faces-redirect=true";
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
		RestaurantType restaurantType = this.restaurantTypeService.findById(loadIdAsLong);
		if(restaurantType == null) {
			return;
		}
		this.restaurantTypeFormBean.setId(restaurantType.getId());
		this.restaurantTypeFormBean.setName(restaurantType.getName());
		
	}

}
