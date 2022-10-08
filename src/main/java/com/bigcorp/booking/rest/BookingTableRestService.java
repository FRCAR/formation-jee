package com.bigcorp.booking.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bigcorp.booking.model.BookingTable;
import com.bigcorp.booking.rest.restbean.BookingTableRestBean;
import com.bigcorp.booking.service.BookingTableService;

@Stateless
@Produces("application/json")
public class BookingTableRestService {

	@Inject
	BookingTableService bookingTableService;

	@GET
	@Produces("application/json")
	@Path("restaurants/{restaurantId}/tables")
	public List<BookingTableRestBean> getByRestaurantId(@PathParam("id") Long restaurantId) {
		return bookingTableService.findByRestaurantId(restaurantId).stream().map(bt -> toBookingTableRestBean(bt))
				.collect(Collectors.toList());
	}

	private BookingTableRestBean toBookingTableRestBean(BookingTable bookingTable) {
		if (bookingTable == null) {
			throw new NotFoundException();
		}
		BookingTableRestBean restBean = new BookingTableRestBean();
		restBean.setId(bookingTable.getId());
		restBean.setName(bookingTable.getName());
		restBean.setSize(bookingTable.getSize());
		return restBean;
	}

}