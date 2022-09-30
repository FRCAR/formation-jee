package com.bigcorp.booking.service;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



//@ExtendWith(WeldJunit5Extension.class)
public class AbstractTest {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected EntityTransaction tx;
//	@WeldSetup
//	protected WeldInitiator weld;

	public AbstractTest() {
		Map<String, String> customProperties = new HashMap<>();
		customProperties.put("javax.persistence.jdbc.url", "jdbc:h2:file:C:/dev/h2-data/booking-database");
		this.emf = Persistence.createEntityManagerFactory("PersisterPU", customProperties);
		//this.weld = WeldInitiator.performDefaultDiscovery();
	}

}
