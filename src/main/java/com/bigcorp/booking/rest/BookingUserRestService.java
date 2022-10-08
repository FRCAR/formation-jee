package com.bigcorp.booking.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bigcorp.booking.model.BookingUser;
import com.bigcorp.booking.rest.restbean.BookingUserRestBean;
import com.bigcorp.booking.service.BookingUserService;

@Stateless
@Path("/users")
@Produces("application/json")
public class BookingUserRestService {

	@Inject
	BookingUserService bookingUserService;

	@GET
	@Produces("application/json")
	public BookingUserRestBean getBookingUserByName(@QueryParam("login") String login,
			@QueryParam("password") String password) {
		return toBookingUserRestBean(bookingUserService.findByEmailPassword(login, password));
	}

	@POST
	@Produces("application/json")
	public BookingUserRestBean postBookingUser(@Valid BookingUserRestBean bookingUserRestBean) {
		if (bookingUserRestBean == null) {
			return null;
		}
		return toBookingUserRestBean(this.bookingUserService.save(toBookingUser(bookingUserRestBean)));
	}

	private BookingUser toBookingUser(BookingUserRestBean bookingUserRestBean) {
		if (bookingUserRestBean == null) {
			return null;
		}
		BookingUser bookingUser = new BookingUser();
		bookingUser.setId(bookingUserRestBean.getId());
		bookingUser.setFirstName(bookingUserRestBean.getFirstName());
		bookingUser.setLastName(bookingUserRestBean.getLastName());
		bookingUser.setEmail(bookingUserRestBean.getEmail());
		bookingUser.setPassword(bookingUserRestBean.getPassword());
		return bookingUser;
	}

	private BookingUserRestBean toBookingUserRestBean(BookingUser bookingUser) {
		if (bookingUser == null) {
			throw new NotFoundException();
		}
		BookingUserRestBean restBean = new BookingUserRestBean();
		restBean.setId(bookingUser.getId());
		restBean.setFirstName(bookingUser.getFirstName());
		restBean.setLastName(bookingUser.getLastName());
		restBean.setEmail(bookingUser.getEmail());
		restBean.setPassword(bookingUser.getPassword());
		return restBean;
	}

}