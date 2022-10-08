package com.bigcorp.booking.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.bigcorp.booking.dao.BookingUserDao;
import com.bigcorp.booking.model.BookingUser;

@Stateless
public class BookingUserService {

	@Inject
	private BookingUserDao bookingUserDao;

	public BookingUser findByEmailPassword(String email, String password) {
		return this.bookingUserDao.findByEmailPassword(email, password);
	}

	@TransactionAttribute
	public BookingUser save(BookingUser bookingUser) {
		return this.bookingUserDao.merge(bookingUser);
	}

}