//package org.mapping;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class DeleteData {
//    public static void main(String[] args) {
//
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory factory = cfg.buildSessionFactory();
//
//        //Session
//        Session s = factory.openSession();
//        Transaction tx = s.beginTransaction();
//
//        Question question = s.get(Question.class, 101);
//        s.remove(question);
//
//        tx.commit();
//
//    }
//}