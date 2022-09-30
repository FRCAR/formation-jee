package com.bigcorp.booking.service;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Restaurant;
	
//@ExtendWith(WeldJunit5Extension.class)
public class RestaurantServiceTest extends AbstractTest	{
	
	@Inject
	RestaurantService restaurantService;
	
//	@BeforeEach
//	public void beforeEachTest() {
//		this.weld.select(RestaurantDao.class).get().setEntityManager(this.emf.createEntityManager());
//	}
	
	@Test
	public void testCreateRestaurant() {
		Restaurant restaurant = this.restaurantService.createRestaurant("coucou");
		Assertions.assertNotNull(restaurant.getId());
	}

}
