package com.edubridge.hibernate.model;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.fasterxml.classmate.AnnotationConfiguration;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			
	        // Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			Configuration cfg = new Configuration();
			cfg.configure("Employee.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = null;
		
			for (int i = 0; i < 3; i++) {
				t = session.beginTransaction();
				Employee e1 = new Employee();
				// e1.setId(1234); bcoz we made id as auto generated
				e1.setFirstName(scanner.next());
				e1.setLastName(scanner.next());

				//Employee e2 = new Employee();
				// e2.setId(5678);
				//e2.setFirstName("mohan");
				//e2.setLastName("patil");

				session.persist(e1);
				
				//session.persist(e2);

				t.commit();
			}

			session.close();
			System.out.println("successfully saved");
		} catch (

		Exception ex) {
			System.out.println("exception " + ex.getMessage());
		}
	}
}