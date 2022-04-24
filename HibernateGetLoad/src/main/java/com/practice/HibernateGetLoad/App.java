package com.practice.HibernateGetLoad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{	
    public static void main( String[] args )
    {
    	Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);    
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(registry);   
        Session session = sf.openSession();
        session.beginTransaction();
        
        //adding data to database
        
        /*Laptop l=new Laptop();
        l.setLid(100);
        l.setBrand("Dell");
        l.setPrice(50000); 
        
        Laptop l1=new Laptop();
        l1.setLid(101);
        l1.setBrand("HP");
        l1.setPrice(56000);  
        
        session.save(l);
        session.save(l1);  */      
        
       /*Laptop laptop=(Laptop)session.get(Laptop.class ,101);
       System.out.println(laptop.toString()); */
        
        //using load ()        
        Laptop laptop=(Laptop)session.load(Laptop.class,101);   //proxy object
        
        try
        {
			Thread.sleep(3000);
		} 
        catch (InterruptedException e) 
        {			
			e.printStackTrace();
		}        
        System.out.println(laptop);
        
        session.getTransaction().commit();
    	session.close();
    }
}
