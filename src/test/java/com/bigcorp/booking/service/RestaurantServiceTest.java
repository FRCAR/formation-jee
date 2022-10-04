package com.bigcorp.booking.service;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.Manager;
import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.model.RestaurantType;

import junit.framework.TestCase;

@RunWith(SingleApplicationComposerRunner.class)
public class RestaurantServiceTest extends TestCase {

	@Inject
	private RestaurantService restaurantService;

	@Inject
	private RestaurantTypeService restaurantTypeService;

	@Inject
	private ManagerService managerService;

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
		restaurant.associateWith(restaurantType);
		restaurant = this.restaurantService.save(restaurant);
		
		Restaurant findById = this.restaurantService.findById(restaurant.getId());
		RestaurantType savedRestaurantType = findById.getRestaurantType();
		Assert.assertNotNull(savedRestaurantType);
		Assert.assertEquals(restaurantType.getName(), savedRestaurantType.getName());
	}
	


	@Test
	public void testSaveWithManagers() throws Exception {
		Manager manager1 = new Manager();
		manager1.setName("manager1");
		manager1 = managerService.save(manager1);

		Manager manager2 = new Manager();
		manager2.setName("manager2");
		manager2 = managerService.save(manager2);
		
		Restaurant restaurant = new Restaurant();
		restaurant.setName("testType4");
		restaurant.associateWith(manager1);
		restaurant.associateWith(manager2);
		restaurant = this.restaurantService.save(restaurant);
		
		Restaurant savedRestaurant = this.restaurantService.findWithManagersById(restaurant.getId());
		Set<Manager> savedManagers= savedRestaurant.getManagers();
		Assert.assertNotNull(savedManagers);
		Assert.assertEquals(2, savedManagers.size());
	}
}