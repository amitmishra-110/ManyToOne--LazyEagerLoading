package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jdbc.hibernate.entity.Course;
import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;


public class FetchJoinDemo {

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
			
			
			//Option 2 : Hibernate Query with HQL
			
			Query<Instructor> query=session.createQuery
					("Select i from Instructor i "
							+ " Join Fetch i.courses "
							+ "where i.id=:theInstructorId",Instructor.class)
					;
			
			
			//Set parameter for Query
			
			query.setParameter("theInstructorId", getId);
			
			
			Instructor tmpInstructor=query.getSingleResult();
			
			System.out.println("Luv2Code Instructor" +tmpInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Luv2Code Courses :"+tmpInstructor.getCourses());
		
			
			System.out.println("LOVE2COE:Done!!");
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
	

	}
