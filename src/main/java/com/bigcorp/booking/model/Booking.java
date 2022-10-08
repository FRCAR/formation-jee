package com.bigcorp.booking.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String name;

	private LocalDateTime dateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "BOOKING_USER_ID")
	private BookingUser bookingUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "TABLE_ID")
	private BookingTable table;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public BookingUser getBookingUser() {
		return bookingUser;
	}

	public void setBookingUser(BookingUser bookingUser) {
		this.bookingUser = bookingUser;
	}

	public BookingTable getTable() {
		return table;
	}

	public void setTable(BookingTable table) {
		this.table = table;
	}
	

}
