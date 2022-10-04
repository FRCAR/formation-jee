package com.bigcorp.booking.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.inject.Named;

import com.bigcorp.booking.dao.RestaurantDao;
import com.bigcorp.booking.model.Restaurant;

@Stateless
public class RestaurantService {

	@Inject
	private RestaurantDao restaurantDao;

	public Restaurant findById(Long id) {
		return this.restaurantDao.findById(id);
	}

	@TransactionAttribute
	public Restaurant save(Restaurant restaurantType) {
		return this.restaurantDao.merge(restaurantType);
	}

	public void remove(Restaurant restaurant) {
		this.restaurantDao.remove(restaurant);
	}

	public List<Restaurant> findByName(String name) {
		return this.restaurantDao.findLike(name);
	}

	public Restaurant findWithManagersById(Long id) {
		return this.restaurantDao.findWithManagersById(id);
	}

	public RestaurantDao getRestaurantDao() {
		return this.restaurantDao;
	}

}