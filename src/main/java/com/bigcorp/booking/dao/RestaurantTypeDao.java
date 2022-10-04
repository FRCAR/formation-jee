package com.bigcorp.booking.dao;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.AbstractAction;

import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.model.RestaurantType;

@Stateless
public class RestaurantTypeDao extends AbstractDao<RestaurantType> {

	@PersistenceContext
	protected EntityManager entityManager;

	public RestaurantType findById(Long id) {
		return super.findById(RestaurantType.class, id);
	}

	public List<RestaurantType> findAll() {
		return this.entityManager.createQuery("select distinct r from RestaurantType r", RestaurantType.class)
				.getResultList();
	}

	public RestaurantType findWithRestaurantsById(Long id) {
		List<RestaurantType> result = this.entityManager.createQuery(
				"select distinct r from RestaurantType r left outer join fetch r.restaurants where r.id = :id",
				RestaurantType.class).setParameter("id", id).getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public List<RestaurantType> findLikeName(String name) {
		if (name == null || name.isEmpty()) {
			return Collections.emptyList();
		}
		TypedQuery<RestaurantType> query = this.entityManager.createQuery(
				"SELECT DISTINCT r FROM RestaurantType r " + " WHERE upper(r.name) like :name", RestaurantType.class);
		query.setParameter("name", "%" + name.toUpperCase() + "%");
		return query.getResultList();
	}

}
