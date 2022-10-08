package com.bigcorp.booking.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.bigcorp.booking.model.BookingUser;

@Stateless
public class BookingUserDao extends AbstractDao<BookingUser> {

	public BookingUser findByEmailPassword(String email, String password) {
		List<BookingUser> result = this.entityManager
				.createQuery(
						"select distinct bu from BookingUser where bu.email = :email and bu.password = :password", BookingUser.class)
				.setParameter("email", email).setParameter("password", password)
				.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

}
