package org.xml_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Person person = new Person(101, "Nikhil", "Pune", "+917058165916");

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(person);
        tx.commit();
        session.close();

        factory.close();
    }
}