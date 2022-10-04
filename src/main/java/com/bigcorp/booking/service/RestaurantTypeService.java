package com.bigcorp.booking.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.bigcorp.booking.dao.RestaurantTypeDao;
import com.bigcorp.booking.model.RestaurantType;

@Stateless
public class RestaurantTypeService {

	@Inject
	private RestaurantTypeDao restaurantTypeDao;

	public RestaurantType findById(Long id) {
		return this.restaurantTypeDao.findById(id);
	}

	public RestaurantType findWithRestaurantsById(Long id) {
		return this.restaurantTypeDao.findWithRestaurantsById(id);
	}

	@TransactionAttribute
	public RestaurantType save(RestaurantType restaurantType) {
		return this.restaurantTypeDao.merge(restaurantType);
	}

	public List<RestaurantType> findLikeName(String restaurantTypeFilter) {
		return this.restaurantTypeDao.findLikeName(restaurantTypeFilter);
	}

	public List<RestaurantType> findAll() {
		return this.restaurantTypeDao.findAll();
	}

}