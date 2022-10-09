package com.bigcorp.booking.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.bigcorp.booking.dao.BookingDao;
import com.bigcorp.booking.model.Booking;

@Stateless
public class BookingService {

	@Inject
	private BookingDao bookingDao;

	public List<Booking> findByUserId(Long userId) {
		return this.bookingDao.findByUserIdWithRestaurant(userId);
	}

	public Booking findById(Long id) {
		return this.bookingDao.findById(id);
	}

	@TransactionAttribute
	public Booking save(Booking booking) {
		return this.bookingDao.merge(booking);
	}

	@TransactionAttribute
	public void deleteById(Long bookingId) {
		this.bookingDao.deleteById(bookingId);
	}

	public List<Booking> findAll() {
		return this.bookingDao.findAll();
	}

}