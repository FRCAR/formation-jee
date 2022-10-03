package com.bigcorp.booking.service;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.RestaurantType;
import com.bigcorp.booking.service.ExampleService;

import junit.framework.TestCase;

@RunWith(SingleApplicationComposerRunner.class)
public class RestaurantTypeServiceTest extends TestCase {

	@Inject
	private RestaurantTypeService restaurantTypeService;

	@Test
	public void test() throws Exception {
		Assert.assertNull(this.restaurantTypeService.findById(0l));
		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setName("testType");
		restaurantType = this.restaurantTypeService.save(restaurantType);
		Assert.assertNotNull(restaurantType);
		this.restaurantTypeService.findById(restaurantType.getId());
	}
}