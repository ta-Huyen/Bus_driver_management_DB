package hibernate.database;

import hibernate.object.Driver;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DriverDBUtil {
    //  Read data from table and create drivers' information list
    public static void loadData(ArrayList<Driver> list) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Driver> result = session.createQuery("from Driver", Driver.class).list();
        list.addAll(result);

        session.getTransaction().commit();
        // close the session
        session.close();
    }

    // Insert driver's data in table
    public static void saveDate(Driver driver) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(driver);

        session.getTransaction().commit();
        // close the session
        session.close();
    }
}
