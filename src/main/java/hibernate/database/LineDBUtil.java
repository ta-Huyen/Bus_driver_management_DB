package hibernate.database;

import hibernate.object.*;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class LineDBUtil {
    //  Read data from table and create lines' information list
    public static void loadData(ArrayList<Line> list) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Line> result = session.createQuery("from Line", Line.class).list();
        list.addAll(result);

        session.getTransaction().commit();
        // close the session
        session.close();
    }

    // Insert line's data in table
    public static void saveDate(Line line) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(line);

        session.getTransaction().commit();
        // close the session
        session.close();
    }
}
