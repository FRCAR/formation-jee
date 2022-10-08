package com.bigcorp.booking.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.bigcorp.booking.dao.BookingTableDao;
import com.bigcorp.booking.model.BookingTable;

@Stateless
public class BookingTableService {

	@Inject
	private BookingTableDao bookingTableDao;

	public List<BookingTable> findByRestaurantId(Long restaurantId) {
		return this.bookingTableDao.findByRestaurantId(restaurantId);
	}

	@TransactionAttribute
	public BookingTable save(BookingTable bookingTable) {
		return this.bookingTableDao.merge(bookingTable);
	}

}