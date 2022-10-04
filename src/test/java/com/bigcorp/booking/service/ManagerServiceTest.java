package com.bigcorp.booking.service;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.ContactData;
import com.bigcorp.booking.model.Manager;

import junit.framework.TestCase;

@RunWith(SingleApplicationComposerRunner.class)
public class ManagerServiceTest extends TestCase {

	@Inject
	private ManagerService managerService;

	@Inject
	private AddressService addressService;

	@Test
	public void testSave() throws Exception {
		Manager manager = new Manager();
		manager.setName("manager1");
		ContactData contactData = new ContactData("12 rue des béliers", "test@yopmail.com", "0606060606","0102030405");
		contactData = addressService.save(contactData);
		manager.setContactData(contactData);
		manager = this.managerService.save(manager);
		
		Manager savedManager = this.managerService.findById(manager.getId());
		
		Assert.assertEquals(contactData.getAddress(), savedManager.getContactData().getAddress());
	}

}