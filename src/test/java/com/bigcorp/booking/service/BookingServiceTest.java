package com.bigcorp.booking.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.Booking;
import com.bigcorp.booking.model.BookingTable;
import com.bigcorp.booking.model.BookingUser;
import com.bigcorp.booking.model.Restaurant;

import junit.framework.TestCase;

@RunWith(SingleApplicationComposerRunner.class)
public class BookingServiceTest extends TestCase {

	@Inject
	private BookingService bookingService;

	@Inject
	private BookingUserService bookingUserService;

	@Inject
	private RestaurantService restaurantService;

	@Inject
	private BookingTableService tableService;

	@Test
	public void testPersist() throws Exception {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("testRestau");
		BookingTable bookingTable = new BookingTable();
		bookingTable.setName("testBookingTable");
		restaurant = restaurantService.save(restaurant);
		restaurant.addTable(bookingTable);
		bookingTable = tableService.save(bookingTable, restaurant.getId());
		Booking booking = new Booking();
		booking.setTable(bookingTable);
		booking.setName("testBooking");
		booking.setDateTime(LocalDateTime.now());
		Booking persistedBooking = bookingService.save(booking);
		Assert.assertNotNull(persistedBooking.getId());
	}

	@Test
	public void testFindByUserId() throws Exception {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("testRestau");
		BookingTable bookingTable = new BookingTable();
		bookingTable.setName("testBookingTable");
		restaurant = restaurantService.save(restaurant);
		restaurant.addTable(bookingTable);
		bookingTable = tableService.save(bookingTable, restaurant.getId());
		Booking booking = new Booking();
		booking.setTable(bookingTable);
		booking.setName("testBooking");
		booking.setDateTime(LocalDateTime.now());
		BookingUser bookingUser = new BookingUser();
		bookingUser.setFirstName("testUser");
		bookingUser = bookingUserService.save(bookingUser);
		booking.setBookingUser(bookingUser);
		Booking persistedBooking = bookingService.save(booking);
		
		
		List<Booking> bookings = bookingService.findByUserId(bookingUser.getId());
		Assert.assertFalse(bookings.isEmpty());
		Assert.assertEquals(restaurant.getName(), bookings.get(0).getTable().getRestaurant().getName());
		
		
		
		
	}
	
	

}