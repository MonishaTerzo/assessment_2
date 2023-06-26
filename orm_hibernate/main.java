package org.example;

import jakarta.persistence.OneToOne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Properties;

public class Main {
    private static Configuration configuration;
    private static SessionFactory sf;
    private static Session session;
    private static Transaction transaction;


    private static void setConfig() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.mariadb.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mariadb://localhost:3306/Database?useSSL=false");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "root");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MariaDBDialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(settings);
        configuration = new Configuration().addAnnotatedClass(employee.class).addAnnotatedClass(department.class).addAnnotatedClass(role.class);
    }



    private static void  transaction(){
        sf = configuration.buildSessionFactory();
     session = sf.openSession();
      transaction = session.beginTransaction();
    }




    public static void  addemployee(){
        transaction(); 
        department d = new department();
        d.setId(1);
        d.setName("engineering");

        role r = new role();
        r.setId(8);
        r.setRname("developer");

        employee e = new employee();
        e.setName("monisha");
        e.setId(63);

        e.setSalary(100000);

        session.save(d);
        session.save(r);
        e.setD(d);
        e.setR(r);
        session.save(e);


        transaction.commit();
      
    }



    //...............exercise 1.................

  
    private static void fetch_the_records(){
      transaction();
        Query command = session.createQuery("from " + "employee");
        List<employee> emp = command.list();
        for (employee i : emp) {
            System.out.println(i);
        }
        transaction.commit();
    }


    //..................exercise2......................


  
    private static void Save_records(){
       transaction();
        department t = new department();
        t.setId(2);
        t.setName("analyst");

        role v = new role();
        v.setId(6);
        v.setRname("analyser");

        employee em = new employee();
        em.setName("aparna");
        em.setId(78);
        em.setSalary(12200);
        session.save(t);
        session.save(v);
        em.setD(t);
        em.setR(v);
        session.save(em);
        transaction.commit();
    }


    //...............exercise 3....................


  

    private static void create_department (Integer id,String name){
       transaction();
        department tm = new department();
        tm.setId(id);
        tm.setName("name");
        session.save(tm);
        transaction.commit();
    }


    //...................exercise 4.............



    private static void map_department (Integer employee_id,Integer dept_id1){
     transaction();
        employee empl = session.get(employee.class, employee_id);
        department department = session.get(department.class, dept_id1);
        empl.setD(department);
        session.save(empl);
        transaction.commit();
    }


    //..................exercise 5...................

    private static void update_the_role (Integer id,String name){
       transaction();
        role roles = session.get(role.class, id);
        roles.setRname(name);
        transaction.commit();
    }

    //exercise 6...................

    private static void delete_the_record (Integer emp_id){
       transaction();
        employee emp1 = session.get(employee.class, emp_id);
        session.delete(emp1);
        transaction.commit();
    }




    public static void main(String[] args) {
       setConfig();
        addemployee();
        fetch_the_records();
        Save_records();
        create_department(3, "sales");
        map_department(78, 3);
        update_the_role(3, "manager");
        delete_the_record(78);

    }}
















