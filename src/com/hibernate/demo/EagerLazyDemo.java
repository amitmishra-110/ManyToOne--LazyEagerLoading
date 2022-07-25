package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Course;
import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;


public class EagerLazyDemo {

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
			
			
			//if session is close before fetching the data 
			//i.e session.close(), it will;  throw data
			//	System.out.println("LUV2CODE:Courses"+instructor.getCourses()); --Lazy Data
			
			//Print Instructor Name
			System.out.println("Instructor Name"+instructor);
			
			//get Courses from instructor
			System.out.println("LUV2CODE:Courses"+instructor.getCourses());
			
					
			
			//commit the transaction
			session.getTransaction().commit();
			session.close();
			
			System.out.println("The Session is Closed!!");
			
			//Doesnt throw error since we used Option 1 where we call the getter method when session was open
			System.out.println("LUV2CODE:Courses"+instructor.getCourses());
			
			
			System.out.println("LOVE2COE:Done!!");
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
	

	}
