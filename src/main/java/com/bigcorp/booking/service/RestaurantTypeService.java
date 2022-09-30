package com.bigcorp.booking.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.bigcorp.booking.dao.RestaurantTypeDao;
import com.bigcorp.booking.model.RestaurantType;

@Named
@Dependent
public class RestaurantTypeService {

	@Inject
	private RestaurantTypeDao restaurantTypeDao;
	
	public List<RestaurantType> findAll(){
		return this.restaurantTypeDao.findAll();
	}

	@Transactional
	public RestaurantType save(RestaurantType restaurantType) {
		return this.restaurantTypeDao.merge(restaurantType);
	}

	public RestaurantType findById(Long id) {
		return this.restaurantTypeDao.find(RestaurantType.class, id);
	}

	public List<RestaurantType> findLikeName(String name) {
		return this.restaurantTypeDao.findLikeName(name);
	}

}