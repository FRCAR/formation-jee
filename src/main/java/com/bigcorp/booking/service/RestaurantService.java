package com.bigcorp.booking.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.bigcorp.booking.dao.RestaurantDao;
import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.model.RestaurantType;

@ApplicationScoped
public class RestaurantService {

	@Inject
	private RestaurantDao restaurantDao;

	@Transactional
	public Restaurant createRestaurant(String name) {
		Restaurant restaurant = new Restaurant();
		restaurant.setName(name);
		this.restaurantDao.merge(restaurant);
		return restaurant;
	}
	
	public List<Restaurant> findByName(String name){
		return this.restaurantDao.findByName(name);
	}
	
	@Transactional
	public Restaurant save(Restaurant restaurant) {
		return this.restaurantDao.merge(restaurant);
	}

	public Restaurant findById(Long id) {
		return this.restaurantDao.find(Restaurant.class, id);
	}

}