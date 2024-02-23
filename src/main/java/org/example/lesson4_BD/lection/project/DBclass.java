package org.example.lesson4_BD.lection.project;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBclass {

    public static void connect() {
        Connect connect = new Connect();

        Session session = connect.getSession();
        Magic magic = new Magic("Волшебная стрела", 0, 0);
        session.beginTransaction();
        session.save(magic);

        magic = new Magic("Волшебная стрела", 0, 0);
        session.save(magic);
        magic = new Magic("Волшебная стрела", 0, 0);
        session.save(magic);
        magic = new Magic("Волшебная стрела", 0, 0);
        session.save(magic);
        session.getTransaction();
        session.close();
    }

//    public static void connecting() {  // get data
//        Connect connect = new Connect();
//        try (Session session = connect.getSession()) {
//            List<Magic> books = session.createQuery("FROM Magic", Magic.class)
//                    .getResultList();
//            books.forEach(System.out::println);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

//    public static void connecting() {  // update data
//        Connect connect = new Connect();
//        try (Session session = connect.getSession()) {
//            String hql = "from Magic where id = :id";
//            Query<Magic> query = session.createQuery(hql, Magic.class);
//            query.setParameter("id", 4);
//            Magic magic = query.getSingleResult();
//            magic.setArmor(100);
//            magic.setName("ярость");
//            session.beginTransaction();
//            session.update(magic);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void deleteDataFromTable() {
        Connect connect = new Connect();
        try (Session session = connect.getSession()) {
            Transaction t  = session.beginTransaction();
            List<Magic> magics = session.createQuery("From Magic " , Magic.class).getResultList();
            magics.forEach(session::delete);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
