package com.bigcorp.booking.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.bigcorp.booking.model.Booking;
import com.bigcorp.booking.model.BookingUser;

@Stateless
public class BookingDao extends AbstractDao<Booking> {

	public List<Booking> findByUserIdWithRestaurant(Long bookingUserId) {
		return this.entityManager
				.createQuery(
						"select distinct booking from Booking booking "
						+ " left outer join fetch booking.table "
						+ " left outer join fetch booking.table.restaurant "
						+ " where booking.bookingUser.id = :bookingUserId "
						+ " order by booking.dateTime desc", Booking.class)
				.setParameter("bookingUserId", bookingUserId)
				.getResultList(); 
	}

	public void deleteById(Long id) {
		this.entityManager
		.createQuery(
				"delete Booking where id = :id", Booking.class)
		.setParameter("id", id)
		.executeUpdate();
	}


}
