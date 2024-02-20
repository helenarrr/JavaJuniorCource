package org.example.lesson2_ReflectionApi.seminar;

import java.util.UUID;

public class Program {

    public static void main(String[] args) throws IllegalAccessException {

        Employee user = new Employee("Elena", "sample@mail.ru");

        UUID pk = UUID.randomUUID();
        QueryBuilder queryBuilder = new QueryBuilder();

        String insertQuery = queryBuilder.buildInsertQuery(user);
        String updateQuery = queryBuilder.buildUpdateQuery(user);
        String selectQuery = queryBuilder.buildSelectQuery(user.getClass(), pk);


        System.out.println("Insert Query: " + insertQuery);
        System.out.println("Update Query: " + updateQuery);
        System.out.println("Select Query: " + selectQuery);


    }
}
