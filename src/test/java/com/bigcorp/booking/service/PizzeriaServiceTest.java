package com.bigcorp.booking.service;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.ContactData;
import com.bigcorp.booking.model.Manager;
import com.bigcorp.booking.model.Pizzeria;

import junit.framework.TestCase;

@RunWith(SingleApplicationComposerRunner.class)
public class PizzeriaServiceTest extends TestCase {

	@Inject
	private PizzeriaService pizzeriaService;


	@Test
	public void testSave() throws Exception {

		Pizzeria pizzeria = new Pizzeria();
		pizzeria.setName("Chez Luigi");
		pizzeria.setPizzaName("Calzone");
		this.pizzeriaService.save(pizzeria);
		
	}

}