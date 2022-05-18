package com.hibernate.manytomanymapping;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("manyToMany.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		AnswerManyToMany ans1 = new AnswerManyToMany();
		ans1.setAnswerName("java is a programming language");
		ans1.setPostedBy("Ajith");

		AnswerManyToMany ans2 = new AnswerManyToMany();
		ans2.setAnswerName("java is a platform");
		ans2.setPostedBy("ajithkumar");

		QuestionManyToMany ques1 = new QuestionManyToMany();
		ques1.setQuestionName("what is java?");
		ArrayList<AnswerManyToMany> a1 = new ArrayList<AnswerManyToMany>();
		a1.add(ans2);
		a1.add(ans1);
		ques1.setAnswers(a1);

		AnswerManyToMany ans3 = new AnswerManyToMany();
		ans3.setAnswerName("hibernate helps java application to intact with database");
		ans3.setPostedBy("Jai Kumar");

		AnswerManyToMany ans4 = new AnswerManyToMany();
		ans4.setAnswerName("hibernate is a java framework");
		ans4.setPostedBy("Arun");

		QuestionManyToMany ques2 = new QuestionManyToMany();
		ques2.setQuestionName("What is hibernate?");
		ArrayList<AnswerManyToMany> a2 = new ArrayList<AnswerManyToMany>();
		a2.add(ans3);
		a2.add(ans4);
		ques2.setAnswers(a2);
		
		session.save(ques2);
		session.save(ques1);

		t.commit();
		session.close();
		System.out.println("success");
	}

}












