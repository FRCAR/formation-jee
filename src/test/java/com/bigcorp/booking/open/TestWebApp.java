package com.bigcorp.booking.open;

import java.util.Properties;

import org.apache.openejb.jee.WebApp;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.testing.Application;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;

import com.bigcorp.booking.dao.AddressDao;
import com.bigcorp.booking.dao.BookingDao;
import com.bigcorp.booking.dao.BookingTableDao;
import com.bigcorp.booking.dao.BookingUserDao;
import com.bigcorp.booking.dao.ExampleDao;
import com.bigcorp.booking.dao.ManagerDao;
import com.bigcorp.booking.dao.PizzeriaDao;
import com.bigcorp.booking.dao.RestaurantDao;
import com.bigcorp.booking.dao.RestaurantTypeDao;
import com.bigcorp.booking.service.AddressService;
import com.bigcorp.booking.service.BookingService;
import com.bigcorp.booking.service.BookingTableService;
import com.bigcorp.booking.service.BookingUserService;
import com.bigcorp.booking.service.ExampleService;
import com.bigcorp.booking.service.ManagerService;
import com.bigcorp.booking.service.PizzeriaService;
import com.bigcorp.booking.service.RestaurantService;
import com.bigcorp.booking.service.RestaurantTypeService;

@Application
public class TestWebApp {
	@org.apache.openejb.testing.Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("bookingTestDatabase");
		unit.setNonJtaDataSource("bookingTestDatabaseUnmanaged");
		unit.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
		unit.setProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
		unit.setProperty("openjpa.Log", "DefaultLevel=WARN,Runtime=INFO,Tool=INFO,SQL=TRACE");

		return unit;
	}

	@org.apache.openejb.testing.Module
	@Classes(cdi = true, value = { 
			RestaurantTypeService.class, RestaurantTypeDao.class,
			ExampleService.class, ExampleDao.class,
			RestaurantService.class, RestaurantDao.class,
			ManagerService.class, ManagerDao.class,
			AddressService.class, AddressDao.class,
			PizzeriaService.class, PizzeriaDao.class,
			BookingService.class, BookingDao.class,
			BookingTableService.class, BookingTableDao.class,
			BookingUserService.class, BookingUserDao.class
			})
	public WebApp app() {
		return new WebApp();
	}

	@Configuration
	public Properties configInMemory() throws Exception {
		Properties p = new Properties();
		p.put("bookingTestDatabase", "new://Resource?type=DataSource");
		p.put("bookingTestDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("bookingTestDatabase.JdbcUrl", "jdbc:hsqldb:mem:testdb");
		return p;
	}

	public Properties configLocalDataBase() throws Exception {
		Properties p = new Properties();
		p.put("bookingTestDatabase", "new://Resource?type=DataSource");
		p.put("bookingTestDatabase.JdbcDriver", "org.apache.derby.client.ClientAutoloadedDriver");
		p.put("bookingTestDatabase.JdbcUrl", "jdbc:derby://localhost:1527/test-junit;create=true");
		p.put("bookingTestDatabase.UserName", "test");
		p.put("bookingTestDatabase.password", "test");
		return p;
	}
}
