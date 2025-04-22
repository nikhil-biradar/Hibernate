package org.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
//
//        //Creating first Questions
//        Question question1 = new Question();
//        question1.setQuestionId(101);
//        question1.setQuestion("What is Java ?");
//
//        //Creating first Answer
//        Answer answer1 = new Answer();
//        answer1.setAnswerId(201);
//        answer1.setAnswer("Java is Programming Language.");
//        answer1.setQuestion(question1);
//
//        //Creating second Answer
//        Answer answer2 = new Answer();
//        answer2.setAnswerId(202);
//        answer2.setAnswer("Java is Object Oriented Programming Language.");
//        answer2.setQuestion(question1);
//
//        //Creating third Answer
//        Answer answer3 = new Answer();
//        answer3.setAnswerId(203);
//        answer3.setAnswer("Java is Statically Typed Programming Language.");
//        answer3.setQuestion(question1);
//
//        List<Answer> list = new ArrayList<>();
//        list.add(answer1);
//        list.add(answer2);
//        list.add(answer3);
//        question1.setAnswers(list);
//
        //Session
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
//
//        s.persist(question1);
//        s.persist(answer1);
//        s.persist(answer2);
//        s.persist(answer3);

        tx.commit();

        //Fetching
        Question newQ = (Question) s.get(Question.class, 101);
        System.out.println(newQ.getQuestion());
        for(Answer a : newQ.getAnswers()){
            System.out.println(a.getAnswer());
        }

        s.close();
        factory.close();
    }
}