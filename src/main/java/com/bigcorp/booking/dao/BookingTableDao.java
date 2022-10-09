package com.bigcorp.booking.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.bigcorp.booking.model.BookingTable;
import com.bigcorp.booking.model.BookingUser;

@Stateless
public class BookingTableDao extends AbstractDao<BookingTable> {

	public List<BookingTable> findByRestaurantId(Long restaurantId) {
		return this.entityManager
				.createQuery(
						"select distinct t from BookingTable t where t.restaurant.id = :restaurantId ", BookingTable.class)
				.setParameter("restaurantId", restaurantId)
				.getResultList();
		
	}

}
