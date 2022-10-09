package com.bigcorp.booking.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.bigcorp.booking.dao.BookingTableDao;
import com.bigcorp.booking.dao.RestaurantDao;
import com.bigcorp.booking.model.BookingTable;
import com.bigcorp.booking.model.Restaurant;

@Stateless
public class BookingTableService {

	@Inject
	private BookingTableDao bookingTableDao;
	
	@Inject
	private RestaurantDao restaurantDao;

	public List<BookingTable> findByRestaurantId(Long restaurantId) {
		return this.bookingTableDao.findByRestaurantId(restaurantId);
	}

	@TransactionAttribute
	public BookingTable save(BookingTable bookingTable, Long restaurantId) {
		Restaurant restaurant = this.restaurantDao.findById(restaurantId);
		bookingTable.setRestaurant(restaurant);
		return this.bookingTableDao.merge(bookingTable);
	}

}