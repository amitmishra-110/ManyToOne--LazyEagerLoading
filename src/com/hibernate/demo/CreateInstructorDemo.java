package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Course;
import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) 
	{
			
		//Create SessionFactory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//Create Session
		Session  session=factory.getCurrentSession();
		
		try
		{
			
			//Create the objects 
			Instructor tmpInstructor=new Instructor("Grace","public","grace.public@gmail.com");
			
			InstructorDetail tmpInstructorDetail=new InstructorDetail
					("http://grace.twitch.com","Gamer");
			
			
			
			
			//Associate the objects together
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);
		
			//start a transaction
			session.beginTransaction();
			
			//Note: This will also save the details of objects
			//because of cascadeType.ALL
			
			System.out.println("Saving Instructor" +tmpInstructor);
			session.save(tmpInstructor);
		
		
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
	

	}
