package com.bigcorp.booking.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.bigcorp.booking.dao.AddressDao;
import com.bigcorp.booking.model.ContactData;

@Stateless
public class AddressService {

	@Inject
	private AddressDao addressDao;

	public ContactData findById(Long id) {
		return this.addressDao.findById(ContactData.class, id);
	}

	@TransactionAttribute
	public ContactData save(ContactData address) {
		return this.addressDao.merge(address);
	}

}