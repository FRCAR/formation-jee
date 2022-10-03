package com.bigcorp.booking.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.AbstractAction;

import com.bigcorp.booking.model.RestaurantType;

@Stateless
public class RestaurantTypeDao extends AbstractDao<RestaurantType> {

	@PersistenceContext
	protected EntityManager entityManager;

	public RestaurantType findById(Long id) {
       return super.findById(RestaurantType.class, id);
	}

}
