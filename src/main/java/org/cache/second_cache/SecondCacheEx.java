package org.cache.second_cache;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondCacheEx {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session1 = factory.openSession();
        /// first
        Student student1 = session1.get(Student.class, 105);
        System.out.println(student1);
        session1.close();

        
        Session session2 = factory.openSession();
        /// second
        Student student2 = session2.get(Student.class, 105);
        System.out.println(student2);
        session2.close();
        factory.close();
    }
}