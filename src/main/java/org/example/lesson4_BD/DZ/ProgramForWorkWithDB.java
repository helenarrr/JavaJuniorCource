package org.example.lesson4_BD.DZ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Создайте базу данных (например, SchoolDB).
//        В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
//        Настройте Hibernate для работы с вашей базой данных.
//        Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
//        Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
//        Убедитесь, что каждая операция выполняется в отдельной транзакции.
public class ProgramForWorkWithDB {


    public static void main(String[] args) throws SQLException {

        MethodsForDB.create();
        MethodsForDB.postData();
        MethodsForDB.getData();

        MethodsForDB.putData();
        MethodsForDB.getData();

        MethodsForDB.deleteData();
        MethodsForDB.getData();
    }


}
