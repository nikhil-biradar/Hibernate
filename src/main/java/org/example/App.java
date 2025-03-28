package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Project Started...");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //creating student
        Student st = new Student();
        st.setId(105);
        st.setName("Rahul");
        st.setCity("Jalgaon");
        System.out.println(st);

        //creating object of address class
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("Pune");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.44);

        //Reading Image
        /*FileInputStream file = new FileInputStream("src/main/java/duck.png");
        byte[] data = new byte[file.available()];
        file.read(data);*/

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(st);
        session.persist(ad);
        tx.commit();
        session.close();
        System.out.println("Done...");

        System.out.println(factory);
        System.out.println(factory.isClosed());
    }
}