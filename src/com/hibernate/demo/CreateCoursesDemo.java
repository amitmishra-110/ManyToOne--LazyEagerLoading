package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Course;
import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;


public class CreateCoursesDemo {

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
		
			//start a transaction
			session.beginTransaction();
			
			//get instructor from db
			
			int getId=1;
			
			Instructor instructor=session.get(Instructor.class,getId);
			
			
			//ManyToOne Example
			
			//create some courses
			
			Course course1=new Course("Java");
			Course course2=new Course("Python");
			Course course3=new Course("C++");
			
			//add courses to instructors
			
			//Note: Instructor table is already populated by running the the CreateInnstructorDemo
			//Still the course table is empty
			//We are adding course and linking to instructor bases on add method written in instructor class
			
			instructor.add(course1);
			instructor.add(course2);
			instructor.add(course3);
			
		
			//save the courses		
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			
			
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
