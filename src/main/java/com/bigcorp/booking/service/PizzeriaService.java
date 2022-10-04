package com.bigcorp.booking.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.bigcorp.booking.dao.PizzeriaDao;
import com.bigcorp.booking.model.Pizzeria;

@Stateless
public class PizzeriaService {

	@Inject
	private PizzeriaDao pizzeriaDao;

	@TransactionAttribute
	public Pizzeria findById(Long id) {
		return this.pizzeriaDao.findById(Pizzeria.class, id);
	}

	@TransactionAttribute
	public Pizzeria save(Pizzeria pizzeria) {
		return this.pizzeriaDao.merge(pizzeria);
	}

}