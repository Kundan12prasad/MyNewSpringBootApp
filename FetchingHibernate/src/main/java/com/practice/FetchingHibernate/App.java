package com.practice.FetchingHibernate;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.practice.FetchingHibernate.Alien;
import com.practice.FetchingHibernate.Laptop;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Alien alien1=new Alien();
    	alien1.setAid(1);
    	alien1.setAname("Kundan");
    	
    	Alien alien2=new Alien();
    	alien2.setAid(2);
    	alien2.setAname("Amit");
    	
    	Alien alien3=new Alien();
    	alien3.setAid(3);
    	alien3.setAname("Mahesh");
    	
    	Laptop laptop1=new Laptop();
    	laptop1.setLid(500);
    	laptop1.setBrand("Dell");
    	laptop1.setPrice("5000");
    	
    	Laptop laptop2=new Laptop();
    	laptop2.setLid(501);
    	laptop2.setBrand("Hp");
    	laptop2.setPrice("45000");
    	
    	Laptop laptop3=new Laptop();
    	laptop3.setLid(502);
    	laptop3.setBrand("Sony");
    	laptop3.setPrice("75000");   	
    	
        
    	Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();     
        SessionFactory sf = config.buildSessionFactory(registry);   
        Session session = sf.openSession();
        
        session.beginTransaction();
        session.save(alien1);
        session.save(alien2);
        session.save(alien3);
        
        session.save(laptop1);
        session.save(laptop2);
        session.save(laptop3);
    	
        Alien a1 = (Alien) session.get(Alien.class, 1);
        System.out.println(a1.getAname());
        
   /*     Collection<Laptop> laps = a1.getLaps();  
        for(Laptop l : laps)
       {
     	System.out.println(l);
       
       } */       
        
        session.getTransaction().commit();
        session.close();
        
    	
    	
    	
    	
    }
}
