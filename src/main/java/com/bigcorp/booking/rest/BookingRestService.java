package com.bigcorp.booking.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bigcorp.booking.model.Booking;
import com.bigcorp.booking.rest.restbean.BookingRestBean;
import com.bigcorp.booking.service.BookingService;

@Stateless
@Produces("application/json")
public class BookingRestService {

	@Inject
	BookingService bookingService;

	@GET
	@Produces("application/json")
	@Path("users/{userId}/bookings")
	public List<BookingRestBean> getByBookingUserId(@PathParam("userId") Long userId) {
		return this.bookingService.findByUserId(userId).stream().map(b -> toRestBean(b)).collect(Collectors.toList());
	}
	
	@DELETE
	@Produces("application/json")
	@Path("bookings/{id}")
	public void deleteByBookingUserId(@PathParam("id") Long id) {
		this.bookingService.deleteById(id);
	}

	@POST
	@Produces("application/json")
	@Path("bookings")
	public BookingRestBean postBooking(@Valid BookingRestBean bookingRestBean) {
		if (bookingRestBean == null) {
			return null;
		}
		return toRestBean(this.bookingService.save(toBooking(bookingRestBean)));
	}

	private Booking toBooking(BookingRestBean bookingRestBean) {
		if (bookingRestBean == null) {
			return null;
		}
		Booking booking = new Booking();
		booking.setId(bookingRestBean.getId());
		booking.setName(bookingRestBean.getName());
		booking.setDateTime(bookingRestBean.getDateTime());
		return booking;
	}

	private BookingRestBean toRestBean(Booking booking) {
		if (booking == null) {
			throw new NotFoundException();
		}
		BookingRestBean restBean = new BookingRestBean();
		restBean.setId(booking.getId());
		restBean.setName(booking.getName());
		restBean.setDateTime(booking.getDateTime());
		if (booking.getTable() != null) {
			restBean.setTableName(booking.getTable().getName());
			if (booking.getTable().getRestaurant() != null) {
				restBean.setTableName(booking.getTable().getName());
			}
		}
		return restBean;
	}

}