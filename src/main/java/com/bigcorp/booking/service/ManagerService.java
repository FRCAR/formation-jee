package com.bigcorp.booking.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.bigcorp.booking.dao.ManagerDao;
import com.bigcorp.booking.model.Manager;

@Stateless
public class ManagerService {

	@Inject
	private ManagerDao managerDao;

	@TransactionAttribute
	public Manager findById(Long id) {
		return this.managerDao.findById(Manager.class, id);
	}

	@TransactionAttribute
	public Manager save(Manager manager) {
		return this.managerDao.merge(manager);
	}

}