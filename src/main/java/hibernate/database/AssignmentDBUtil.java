package hibernate.database;

import hibernate.object.*;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class AssignmentDBUtil {
    //  Read data from table and create assignment's information list
    public static void loadData(ArrayList<Assignment> list) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Assignment> result = session.createQuery("from Assignment", Assignment.class).list();
        list.addAll(result);

        session.getTransaction().commit();
        // close the session
        session.close();
    }

    // Insert assignment's data in table
    public static void saveDate(Assignment assignment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(assignment);

        session.getTransaction().commit();
        // close the sessi
    }

    public static void updateData(Assignment assignment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.merge(assignment);

        session.getTransaction().commit();
        // close the session
        session.close();
    }
}