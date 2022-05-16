package com.edubridge.onetoonemapping;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Configuration cfg = new Configuration();
			cfg.configure("Hibernate.cfg.xml");// populates the data of the configuration file

			SessionFactory factory = cfg.buildSessionFactory(); // creating session factory object

			Session session = factory.openSession(); // creating session object

			Transaction t = session.beginTransaction(); // creating transaction object

			Address address = new Address();
			address.setCity("mangalore");
			address.setState("Karnataka");

			Employee employee = new Employee();
			employee.setName("satish");
			employee.setEmail("satish@gmail.com");
			employee.setAddress(address);// employee is mapping with address
			address.setEmployee(employee);// address is mapping with employee

			session.save(employee);

			Address address1 = new Address();
			address1.setCity("banglore");
			address1.setState("karnataka");
			Employee employee1 = new Employee();
			employee1.setName("ajith");
			employee1.setEmail("ajith@gmail.com");
			employee1.setAddress(address1);
			address1.setEmployee(employee1);
			session.save(address1);

			Employee employee2 = new Employee();
			employee2.setName("ajithkumar");
			employee2.setEmail("ajithkumar@gmail.com");
			Address address2 = session.get(Address.class, 3); // taking the 2nd employee address as also a 3rd employee
			employee2.setAddress(address2);
			address2.setEmployee(employee2);
			session.save(address2);

			t.commit();
			session.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
