package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;

public class GetInstructorDetailDemo 
{
	
	public static void main(String[] args) 
	{
		
	
	
	//Create SessionFactory
	SessionFactory factory=new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
	
	//Create Session
	Session  session=factory.getCurrentSession();
	
	try
	{
	
		
	
		//start a transaction
		session.beginTransaction();
		
		
		//get the instructor detail object
		
		int theId=2;
		
		InstructorDetail tmpInstructorDetail=session.get(InstructorDetail.class,theId);
		
		
		//print the instructor detail
		System.out.println("The tempinstructorDetail"+tmpInstructorDetail);
		
		//print the associated instructor
		
		System.out.println("The associated instructor"+tmpInstructorDetail.getInstructor());
	
		
		//commit the transaction
		session.getTransaction().commit();
		System.out.println("Done!!");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		//handle connection leak issue
		session.close();
		factory.close();
	}
}

}


