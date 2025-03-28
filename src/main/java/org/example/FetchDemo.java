package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        //get, load
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        //get
        Student student = (Student) session.get(Student.class, 105);
        System.out.println(student.getName());

        Address address = (Address) session.get(Address.class, 1);
        System.out.println(address);
        System.out.println(address.getStreet() + " : " + address.getCity());

        factory.close();
    }
}
