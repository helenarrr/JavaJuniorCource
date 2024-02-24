package org.example.lesson4_BD.DZ;

import org.example.lesson4_BD.lection.project.Connect;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class MethodsForDB {

    private static String URL = "jdbc:mysql://localhost:3306";
    private static String USER = "root";
    private static String PASSWORD = "admin";


    public static void create() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP SCHEMA IF EXISTS `SchoolDB`;");
            statement.execute("CREATE SCHEMA `SchoolDB`;");
            statement.execute
                    ("CREATE TABLE `SchoolDB`.`Courses` (`id` INT NOT NULL AUTO_INCREMENT, `title` VARCHAR(45), `duration` VARCHAR(45), PRIMARY KEY(`id`));");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


//    Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.


    public static void useDatabase() {
        String useDatabaseSQL = "USE `SchoolDB`;";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        } catch (SQLException sqlException) {
            throw new RuntimeException();
        }
    }

    public static void postData() {
        Connect connect = new Connect();

        Session session = connect.getSession();
        Course course = new Course("Математика", "месяц");
        session.beginTransaction();
        session.save(course);

        course = new Course("Русский язык", "год");
        session.save(course);
        session.getTransaction();
        session.close();

        System.out.println("Успешное добавление данных в таблицу");
    }

    public static void getData() {
        Connect connect = new Connect();
        try (Session session = connect.getSession()) {
            List<Course> courses = session.createQuery("FROM Course", Course.class)
                    .getResultList();
            courses.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void putData() {
        Connect connect = new Connect();
        try (Session session = connect.getSession()) {
            String hql = "from Course where id = :id";
            Query<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("id", 1);
            Course course = query.getSingleResult();
            course.setTitle("Литература");
            course.setDuration("2 года");
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
            System.out.println("Успешное обновление данных в таблице");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteData() {
        Connect connect = new Connect();
        try (Session session = connect.getSession()) {
            Transaction t = session.beginTransaction();
            List<Course> courses = session.createQuery("From Course ", Course.class).getResultList();
            courses.forEach(session::delete);
            t.commit();
            System.out.println("Успешное удаление данных из таблицы");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
