package org.example.lesson2_ReflectionApi.DZ.task2;

import java.lang.reflect.Field;
import java.util.UUID;

public class QueryBuilderDZ {

    /**
     * TODO: Доработать метод Delete в рамках выполнения домашней работы
     *
     * @return
     */
    public String buildDeleteQuery(Object object, UUID pk) throws IllegalAccessException {
        Class<?> clazz = object.getClass();

        if (!clazz.isAnnotationPresent(Table.class)) {
            return "";
        }
        StringBuilder query = new StringBuilder("DELETE FROM ");

        Table tableAnnotation = clazz.getAnnotation(Table.class);
        query
                .append(tableAnnotation.name())
                .append("(");

        Field[] fields = clazz.getDeclaredFields();
        if (query.charAt(query.length() - 2) == ',') {
            query.delete(query.length() - 2, query.length());
        }
        query.append(") WHERE ");

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey()) {
                    query.append(columnAnnotation.name())
                            .append(" = ")
                            .append("'")
                            .append(pk)
                            .append("'");
                    break;
                }
            }
        }

        return query.toString();

    }
}



