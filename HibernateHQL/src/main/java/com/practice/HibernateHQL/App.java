package com.practice.HibernateHQL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Map;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
        
    	Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);    
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(registry);   
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        //hql part2a
       /*Query q =session.createQuery("select rollno,name,marks from Student where rollno=16");
       Object[] student = (Object[])q.uniqueResult();
       
       System.out.println(student[0]+  ": " +student[1]+ ": " +student[2]);
       /*for(Object obj: student)
       {
    	   System.out.println(obj);
    	   
       } */
       //HQL part2b
       
      /* Query q =session.createQuery("select rollno,name,marks from Student");
      List<Object[]> students = (List<Object[]>)q.list();
      for(Object[] student:students)
      {
    	  System.out.println(student[0]+  ": " +student[1]+ ": " +student[2]);
    	  
      } */     
       
        
       
       //HQLpart1
    /* Query q= session.createQuery("from Student where marks>50");
     List<Student>students =q.list();
     
     for(Student s:students) 
     {
    	 System.out.println(s);    	 
     } /*/
        
      /* Query q=session.createQuery("from Student where rollno=10");
       Student student =(Student)q.uniqueResult();
       System.out.println(student); */
        
       /* Random r=new Random ();
        for(int i=1;i<=50;i++)
        {       	
        	Student s=new Student();
        	s.setRollno(i);
    	    s.setName("Name" + i);
    	    s.setMarks(r.nextInt(100));
      	    session.save(s);
        } */
      
      
      //using SQL in Hibernate (part 3a)
        
       /* SQLQuery query=session.createSQLQuery("select * from Student where marks >60");
        query.addEntity(Student.class);
        List<Student> students=query.list();
        for(Student student:students)
        {
        	System.out.println(student);
        } */
        
      //using SQL in Hibernate (part 3b)
        
      SQLQuery query =session.createSQLQuery("select name,marks from Student where marks>60");
      query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
      List students=query.list();
      
      for(Object obj:students)
      {
    	  Map m=(Map)obj;
    	  System.out.println(m.get("name")+ ": " + m.get("marks"));
      }
        
        session.getTransaction().commit();
        session.close();    	
    	
    	
    }
}
