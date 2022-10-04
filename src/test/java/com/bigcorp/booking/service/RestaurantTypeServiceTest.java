package com.bigcorp.booking.service;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.model.RestaurantType;

import junit.framework.TestCase;

@RunWith(SingleApplicationComposerRunner.class)
public class RestaurantTypeServiceTest extends TestCase {

	@Inject
	private RestaurantTypeService restaurantTypeService;

	@Inject
	private RestaurantService restaurantService;

	@Test
	public void test() throws Exception {
		Assert.assertNull(this.restaurantTypeService.findById(0l));
		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setName("testType");
		restaurantType = this.restaurantTypeService.save(restaurantType);
		Assert.assertNotNull(restaurantType);
		this.restaurantTypeService.findById(restaurantType.getId());
	}
	
	@Test
	public void testFindWithRestaurants() throws Exception {
		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setName("coucou");
		restaurantType = restaurantTypeService.save(restaurantType);
		
		Restaurant restaurant = new Restaurant();
		restaurant.setName("testType3");
		restaurant.associateWith(restaurantType);
		restaurant = this.restaurantService.save(restaurant);
		
		restaurantType = this.restaurantTypeService.findWithRestaurantsById(restaurantType.getId());
		Assert.assertNotNull(restaurantType);
		Assert.assertNotNull(restaurantType.getRestaurants());
		Assert.assertFalse(restaurantType.getRestaurants().isEmpty());
	}

}