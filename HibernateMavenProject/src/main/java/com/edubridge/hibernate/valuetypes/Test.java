package com.edubridge.hibernate.valuetypes;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//session object from another cls to use in different main class 
			/*
			 * public class UserSession {
			 * 
			 * public static Session getSession() { Configuration cfg=new Configuration();
			 * cfg.configure("Hibernate.cfg.xml"); SessionFactory
			 * factory=cfg.buildSessionFactory(); Session session=factory.openSession();
			 * return session; }
			 * 
			 * }
			 */

			Configuration cfg = new Configuration();
			cfg.configure("UserDetails.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();

			Address address = new Address();
			address.setStreet("1st block");
			address.setCity("banglore");
			address.setState("ka");
			address.setPincode("324322");

			UserDetails userDetail = new UserDetails();
			userDetail.setAddress(address);
			//userDetail.setUserId(100);
			userDetail.setDob(new Date());
			userDetail.setPhone("9688566307");
			userDetail.setUserName("ajith");
			
			session.save(userDetail);

			//load method
			System.out.println("getting data from load method");
			UserDetails userDetails = session.load(UserDetails.class, 1);
			System.out.println(userDetails); // we have to string method
			
			//without to string method ..using getters method 
			/*
			 * System.out.println(userDetails.getUserName());
			 * System.out.println(userDetails.getPhone());
			 * System.out.println(userDetails.getUserId());
			 * System.out.println(userDetails.getAddress().getCity()); //address is
			 * valuetypes System.out.println(userDetails.getAddress().getPincode());
			 */
			
			//get method
			System.out.println("getting data from get method");
			UserDetails userDetails1 = session.get(UserDetails.class, 1);
			System.out.println(userDetails1); // we have to string method

			t.commit();
			session.close();
			
			//saveOrUpdate
			Session session1 = factory.openSession();
			Transaction t1 = session1.beginTransaction();

			Address address1 = new Address();
			address1.setStreet("1st block");
			address1.setCity("banglore");
			address1.setState("ka");
			address1.setPincode("324322");

			UserDetails userDetail1 = new UserDetails();
			userDetail1.setAddress(address);
			userDetail1.setDob(new Date());
			userDetail1.setPhone("9688566307");
			userDetail1.setUserName("kumar");
			
			session1.saveOrUpdate(userDetail1);
			userDetail1.setPhone("123");
			System.out.println("getting data from load and saveOrUpdate method");
			UserDetails userDetails2 = session1.load(UserDetails.class, 2);
			System.out.println(userDetails2);
			t1.commit();
			session1.close();
			
			//update
			Session session2 = factory.openSession();
			Transaction t2 = session2.beginTransaction();

			session2.update(userDetail1);
			userDetail1.setPhone("12356");
			System.out.println("getting data from load and Update method");
			UserDetails userDetails4 = session2.load(UserDetails.class, 2);
			System.out.println(userDetails4);
			t2.commit();
			session2.close();
			
			
			System.out.println("successfully saved");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
