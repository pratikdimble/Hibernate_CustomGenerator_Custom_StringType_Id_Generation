package com.app.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.domain.lucky_draw;
import com.app.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) 
	{
		Session ses = null;
		lucky_draw coupen = null;
		Transaction tx = null;

		ses = HibernateUtil.getSession();
				
		coupen=new lucky_draw();
		coupen.setCustomerName("Rohit");
		coupen.setBillAmount(80000);
		
		try {
			tx = ses.beginTransaction();
			String id=(String)ses.save(coupen);
			tx.commit();
			System.out.println("object is saved");
			System.out.println("\n\t***Generated ID Value::: "+id);
		} catch (Exception e) {
			tx.rollback();

		}
		//close the session and Session Factory
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
		System.out.print("\n\t\t ==PROGRAMME BY PRATIK DIMBLE==\n\n\n");

		

	}

}
