package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Course;
import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;


public class GetInstructorCoursesDemo {

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
			
			//OneToMany Example
			
			//Print Instructor Name
			System.out.println("Instructor Name"+instructor.getFirstName());
			
			//get Courses from instructor
			System.out.println("Courses"+instructor.getCourses());
			
					
			
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
