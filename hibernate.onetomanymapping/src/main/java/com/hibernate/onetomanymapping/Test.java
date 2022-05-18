package com.hibernate.onetomanymapping;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("question.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Answer ans1 = new Answer();
		ans1.setAnswername("Java is a programming language");

		Answer ans2 = new Answer();
		ans2.setAnswername("Java is a platform");

		Answer ans3 = new Answer();
		ans3.setAnswername("hibernate is a java framework");

		Answer ans4 = new Answer();
		ans4.setAnswername("uesd for java application to intact with database");

		//to assign the another ans for same question
		/*
		 * Question question = session.get(Question.class, 1); Answer ans5 = new
		 * Answer(); ans5.setAnswername("oops concept"); question.setAnswers(list1);
		 * list1.add(ans5); session.save(question);
		 */

		// answer for 1st question
		ArrayList<Answer> list1 = new ArrayList<Answer>();

		list1.add(ans1);
		list1.add(ans2);

		// answer for 2nd question

		ArrayList<Answer> list2 = new ArrayList<Answer>();
		list2.add(ans3);
		list2.add(ans4);

		Question question1 = new Question();
		question1.setQname("What is Java?");
		question1.setAnswers(list1);

		Question question2 = new Question();
		question2.setQname("What is Hibernate?");
		question2.setAnswers(list2);

		session.save(question1);
		session.save(question2);

		t.commit();
		session.close();
		System.out.println("success");
	}
}
