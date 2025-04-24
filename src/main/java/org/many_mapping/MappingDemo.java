package org.many_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

public class MappingDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setEmployeeId(101);
        employee1.setEmployeeName("Nikhil");

        employee2.setEmployeeId(102);
        employee2.setEmployeeName("Nitin");

        Project project1 = new Project();
        Project project2 = new Project();

        project1.setProjectId(1001);
        project1.setProjectName("Library Management System");

        project2.setProjectId(1002);
        project2.setProjectName("Customer Relationship Management");

        List<Employee> list1 = new ArrayList<Employee>();
        List<Project> list2 = new ArrayList<Project>();

        list1.add(employee1);
        list1.add(employee2);

        list2.add(project1);
        list2.add(project2);

        employee1.setProjects(list2);
        project2.setEmployees(list1);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);

        tx.commit();
        session.close();
        factory.close();
    }
}