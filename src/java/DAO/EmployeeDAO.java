/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Emp;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Dilip J Sarvaiya
 */
public class EmployeeDAO {
    
       static Session session=null;
    public static void save(Emp bean)
    {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.save(bean);
        t.commit();
        session.close();
    }
    public static void update(Emp bean)
    {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.update(bean);
        t.commit();
        session.close();
    }
     public static void delete(Emp bean)
    {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.delete(bean);
        t.commit();
        session.close();
    }
     public static List<Emp> viewAll()
    {
        String hql = "from Emp";
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Emp> users = query.list();
        session.close();
        return users;
    }
     
     //For a Single User information
     public static Emp viewSingle(int id)
    {
        String hql = "from Emp where id='"+id+"'";
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Emp> users = query.list();
        session.close();
        Emp obj=null;
        if(!users.isEmpty())
        obj = users.get(0);

        return obj;
    }
}
