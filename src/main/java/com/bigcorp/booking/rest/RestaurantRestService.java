package com.bigcorp.booking.rest;
 
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.model.RestaurantType;
import com.bigcorp.booking.rest.restbean.RestaurantRestBean;
import com.bigcorp.booking.service.RestaurantService;
import com.bigcorp.booking.service.RestaurantTypeService;
 
@Stateless
@Path("/restaurants")
@Produces("application/json")
public class RestaurantRestService {
	
	@Inject
	RestaurantService restaurantService;
	
	@Inject
	RestaurantTypeService restaurantTypeService;
 
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public RestaurantRestBean getRestaurantById(@PathParam("id") String id) {
        return toRestaurantRestBean(this.restaurantService.findById(Long.decode(id)));
    }
 
    @POST
    @Produces("application/json")
    public RestaurantRestBean postRestaurant(@Valid RestaurantRestBean restaurantRestBean) {
    	if(restaurantRestBean == null) {
    		return null;
    	}
    	return toRestaurantRestBean(this.restaurantService.save(toRestaurant(restaurantRestBean)));
    }
    
    private Restaurant toRestaurant(RestaurantRestBean restaurantRestBean) {
    	if(restaurantRestBean == null) {
    		return null;
    	}
    	Restaurant restaurant = new Restaurant();
    	restaurant.setId(restaurantRestBean.getId());
    	restaurant.setName(restaurantRestBean.getName());
		restaurant.setAddress(restaurantRestBean.getAddress());
		restaurant.setEmail(restaurantRestBean.getEmail());
		restaurant.setPhone(restaurantRestBean.getPhone());
		restaurant.setActive(restaurantRestBean.getActive());
    	if(restaurantRestBean.getRestaurantTypeId() != null) {
    		RestaurantType restaurantType = restaurantTypeService.findById(restaurantRestBean.getRestaurantTypeId());
    		restaurant.setRestaurantType(restaurantType);
    	}
    	return restaurant;
    }

    
    private RestaurantRestBean toRestaurantRestBean(Restaurant restaurant) {
    	if(restaurant == null) {
            throw new NotFoundException();
    	}
    	RestaurantRestBean restBean = new RestaurantRestBean();
    	restBean.setId(restaurant.getId());
    	restBean.setName(restaurant.getName());
		restBean.setAddress(restaurant.getAddress());
		restBean.setEmail(restaurant.getEmail());
		restBean.setPhone(restaurant.getPhone());
		restBean.setActive(restaurant.getActive());
    	if(restaurant.getRestaurantType() != null) {
    		restBean.setRestaurantTypeId(restaurant.getRestaurantType().getId());
    	}
    	return restBean;
    }
    
}