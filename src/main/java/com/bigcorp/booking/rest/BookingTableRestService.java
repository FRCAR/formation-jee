package com.bigcorp.booking.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bigcorp.booking.model.BookingTable;
import com.bigcorp.booking.rest.restbean.BookingTableRestBean;
import com.bigcorp.booking.service.BookingTableService;

@Stateless
@Produces("application/json")
@Path("/restaurants")
public class BookingTableRestService {

	@Inject
	BookingTableService bookingTableService;

	@GET
	@Produces("application/json")
	@Path("/{id}/tables")
	public List<BookingTableRestBean> getByRestaurantId(@PathParam("id") String restaurantId) {
		return bookingTableService.findByRestaurantId(Long.decode(restaurantId)).stream().map(bt -> toBookingTableRestBean(bt))
				.collect(Collectors.toList());
	}

	@POST
	@Produces("application/json")
	@Path("/{restaurantId}/tables")
	public BookingTableRestBean post(@PathParam("restaurantId") String restaurantId, BookingTableRestBean restBean) {
		return toBookingTableRestBean(bookingTableService.save(toBookingTable(restBean), Long.decode(restaurantId)));
	}

	private BookingTableRestBean toBookingTableRestBean(BookingTable bookingTable) {
		if (bookingTable == null) {
			throw new NotFoundException();
		}
		BookingTableRestBean restBean = new BookingTableRestBean();
		restBean.setId(bookingTable.getId());
		restBean.setName(bookingTable.getName());
		restBean.setSize(bookingTable.getSize());
		if(bookingTable.getRestaurant() != null) {
			restBean.setRestaurantId(bookingTable.getRestaurant().getId());
		}
		return restBean;
	}

	private BookingTable toBookingTable(BookingTableRestBean restBean) {
		if (restBean == null) {
			throw new NotFoundException();
		}
		BookingTable bean = new BookingTable();
		bean.setId(restBean.getId());
		bean.setName(restBean.getName());
		bean.setSize(restBean.getSize());
		return bean;
	}

}