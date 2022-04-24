package com.practice.HibernateFirstWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
	public static void main( String[] args )
    {       
        Alien telusko= new Alien();          
        
Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();           
        //to fetch the data from database
        telusko =(Alien)session.get(Alien.class, 102);
        
        tx.commit(); 
        System.out.println(telusko);
        session.close();
        
    }
}
