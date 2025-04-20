package org.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //Creating first Question
        Question question1 = new Question();
        question1.setQuestionId(101);
        question1.setQuestion("What is Java ?");

        //Creating first Answer
        Answer answer1 = new Answer();
        answer1.setAnswerId(201);
        answer1.setAnswer("Java is Programming Language.");
        question1.setAnswer(answer1);
        answer1.setQuestion(question1);

        //Creating second Question
        Question question2 = new Question();
        question2.setQuestionId(102);
        question2.setQuestion("What is JDK ?");

        //Creating second Answer
        Answer answer2 = new Answer();
        answer2.setAnswerId(202);
        answer2.setAnswer("JDK is Java Development Kit");
        question2.setAnswer(answer2);
        answer2.setQuestion(question2);

        //Session
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();


        s.persist(question1);
        s.persist(question2);
        s.persist(answer1);
        s.persist(answer2);
        tx.commit();

        //Fetching
        Question newQ = (Question) s.get(Question.class, 101);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer().getAnswer());

        Question newQ1 = (Question) s.get(Question.class, 102);
        System.out.println(newQ1.getQuestion());
        System.out.println(newQ1.getAnswer().getAnswer());


        s.close();
        factory.close();
    }
}