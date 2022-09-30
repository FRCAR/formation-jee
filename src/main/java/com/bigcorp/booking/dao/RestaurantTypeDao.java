package com.bigcorp.booking.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.bigcorp.booking.model.RestaurantType;

@Named
@ApplicationScoped
public class RestaurantTypeDao extends BaseDao<RestaurantType> {

	public List<RestaurantType> findAll() {
		return this.entityManager.createQuery("select r from RestaurantType r", RestaurantType.class).getResultList();
	}

	public List<RestaurantType> findLikeName(String name) {
		if (name == null) {
			name = "";
		}
		return this.entityManager
				.createQuery("select r from RestaurantType r where r.name like :name ", RestaurantType.class)
				.setParameter("name", BaseDao.LIKE_JOKER + name + BaseDao.LIKE_JOKER).getResultList();
	}

}