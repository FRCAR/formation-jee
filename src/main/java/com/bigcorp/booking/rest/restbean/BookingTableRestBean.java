package com.bigcorp.booking.rest.restbean;

public class BookingTableRestBean {

	private Long id;

	private String name;

	private Integer size;
	
	private Long restaurantId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	

}
