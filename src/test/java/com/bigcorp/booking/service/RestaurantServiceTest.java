package com.bigcorp.booking.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.model.RestaurantType;

import junit.framework.TestCase;

@RunWith(SingleApplicationComposerRunner.class)
public class RestaurantServiceTest extends TestCase {

	@Inject
	private RestaurantService restaurantService;

	@Inject
	private RestaurantTypeService restaurantTypeService;

	@Test
	public void testSave() throws Exception {
		Assert.assertNull(this.restaurantService.findById(0l));
		Restaurant restaurant = new Restaurant();
		restaurant.setName("testType1");
		restaurant = this.restaurantService.save(restaurant);
		Assert.assertNotNull(restaurant);
		this.restaurantService.findById(restaurant.getId());
	}

	@Test
	public void testFindLike() throws Exception {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("testType2");
		restaurant = this.restaurantService.save(restaurant);
		List<Restaurant> restaurants = this.restaurantService.findByName("estTy");
		Assert.assertNotNull(restaurants);
		Assert.assertFalse(restaurants.isEmpty());
	}

	@Test
	public void testSaveWithType() throws Exception {
		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setName("coucou");
		restaurantType = restaurantTypeService.save(restaurantType);
		
		Restaurant restaurant = new Restaurant();
		restaurant.setName("testType3");
		restaurant.setRestaurantType(restaurantType);
		restaurant = this.restaurantService.save(restaurant);
		
		Restaurant findById = this.restaurantService.findById(restaurant.getId());
		RestaurantType savedRestaurantType = findById.getRestaurantType();
		Assert.assertNotNull(savedRestaurantType);
		Assert.assertEquals(restaurantType.getName(), savedRestaurantType.getName());
	}
}