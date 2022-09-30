package com.bigcorp.booking.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.model.RestaurantType;

@Named
@ApplicationScoped
public class RestaurantDao extends BaseDao<Restaurant> {

	public List<Restaurant> findByName(String name) {
		return this.entityManager
				.createQuery("select r from Restaurant r where r.name like :name ", Restaurant.class)
				.setParameter("name", LIKE_JOKER + name + LIKE_JOKER).getResultList();
	}

    public List<Restaurant> findAll() {
        return this.entityManager.createQuery("select r from Restaurant r", Restaurant.class).getResultList();
    }

}