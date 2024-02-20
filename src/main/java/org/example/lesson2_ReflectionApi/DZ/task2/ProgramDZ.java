package org.example.lesson2_ReflectionApi.DZ.task2;


import java.util.UUID;

public class ProgramDZ {

//    Доработайте метод генерации запроса на удаление объекта из таблицы БД (DELETE FROM <Table> WHERE ID = '<id>')
//    В классе QueryBuilder который мы разработали на семинаре.


    public static void main(String[] args) throws IllegalAccessException {
        EmployeeDZ employee = new EmployeeDZ("Elena", "mail@ru");

        UUID pk = UUID.randomUUID();
        QueryBuilderDZ queryBuilder = new QueryBuilderDZ();

        String deleteQuery = queryBuilder.buildDeleteQuery(employee, pk);

        System.out.println("Delete query: " + deleteQuery);
    }

}
