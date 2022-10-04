package com.bigcorp.booking.dao;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.bigcorp.booking.model.Restaurant;

@Stateless
public class RestaurantDao extends AbstractDao<Restaurant> {

	@SuppressWarnings("unchecked")
	public Restaurant findById(Long id) {
		List<Restaurant> result = this.entityManager
				.createQuery(
						"select distinct r from Restaurant r left outer join fetch r.restaurantType where r.id = :id")
				.setParameter("id", id).getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	@SuppressWarnings("unchecked")
	public Restaurant findWithManagersById(Long id) {
		List<Restaurant> result = this.entityManager
				.createQuery("select distinct r from Restaurant r left outer join fetch r.managers where r.id = :id")
				.setParameter("id", id).getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public List<Restaurant> findLike(String name) {
		if (name == null || name.isEmpty()) {
			return Collections.emptyList();
		}
		TypedQuery<Restaurant> query = this.entityManager.createQuery(
				"SELECT DISTINCT r FROM Restaurant r " + " WHERE upper(r.name) like :name", Restaurant.class);
		query.setParameter("name", "%" + name.toUpperCase() + "%");
		return query.getResultList();
	}

}
