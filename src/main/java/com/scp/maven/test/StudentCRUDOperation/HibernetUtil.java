package com.scp.maven.test.StudentCRUDOperation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernetUtil {

	static SessionFactory sessionFactory=null;
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null)
			 sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
			return sessionFactory;		
	  /* if(sessionFactory==null)
		try{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		}
		catch (Exception e) {
			System.out.println(e);
			throw new ExceptionInitialize(e);
		}
		else{
		return sessionFactory;
		}*/
	/*
	try{
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
	}
	catch (Exception e) {
		System.out.println(e);
		throw new ExceptionInitialize(e);
	}
	*/
	
	
	}
}
