package com.bigcorp.booking.open;

import java.util.Properties;

import org.apache.openejb.jee.WebApp;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.testing.Application;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;

import com.bigcorp.booking.dao.ExampleDao;
import com.bigcorp.booking.dao.RestaurantDao;
import com.bigcorp.booking.service.ExampleService;
import com.bigcorp.booking.service.RestaurantService;

@Application
public class TestWebApp {
	@org.apache.openejb.testing.Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("bookingTestDatabase");
		unit.setNonJtaDataSource("bookingTestDatabaseUnmanaged");
		unit.setProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
		return unit;
	}

	@org.apache.openejb.testing.Module
	@Classes(cdi = true, value = { RestaurantService.class, RestaurantDao.class,
			ExampleService.class, ExampleDao.class})
	public WebApp app() {
		return new WebApp();
	}

	@Configuration
	public Properties config() throws Exception {
		Properties p = new Properties();
		p.put("bookingTestDatabase", "new://Resource?type=DataSource");
		p.put("bookingTestDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("bookingTestDatabase.JdbcUrl", "jdbc:hsqldb:mem:testdb");
		return p;
	}
}
