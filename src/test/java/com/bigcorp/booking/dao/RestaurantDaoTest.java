package com.bigcorp.booking.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.service.AbstractTest;

public class RestaurantDaoTest extends AbstractTest {

	@Inject
	private RestaurantDao restaurantDao;

	@BeforeEach
	public void beforeEachTest() {
		//this.weld.select(RestaurantDao.class).get().setEntityManager(this.emf.createEntityManager());
		this.restaurantDao = new RestaurantDao();
		this.em = this.emf.createEntityManager();
		this.restaurantDao.setEntityManager(em);
        this.tx = em.getTransaction();
        tx.begin();
	}
	
	
	@AfterEach
	public void afterEachTest() {
		this.tx.rollback();
		em.close();
	}
	
	@Test
	public void testSave() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("coucou");
		restaurantDao.merge(restaurant);
		Assertions.assertNotNull(restaurant.getId());
		
		Restaurant restaurantFromDb = restaurantDao.find(Restaurant.class, restaurant.getId());
		Assertions.assertEquals(restaurant.getId(), restaurantFromDb.getId());
		Assertions.assertEquals(restaurant.getName(), restaurantFromDb.getName());
		
		List<Restaurant> restaurants = restaurantDao.findAll();
		Assertions.assertFalse(restaurants.isEmpty());
		
		restaurantDao.removeById(Restaurant.class, restaurant.getId());
		
		restaurants = restaurantDao.findAll();
		Assertions.assertTrue(restaurants.isEmpty());
	}
	
	@Test
	public void testFindByName(){
		Restaurant restaurant = new Restaurant();
		restaurant.setName("coucou");
		restaurantDao.merge(restaurant);
		
		List<Restaurant> restaurants = this.restaurantDao.findByName("ouco");
		Assertions.assertFalse(restaurants.isEmpty());
	}

}
