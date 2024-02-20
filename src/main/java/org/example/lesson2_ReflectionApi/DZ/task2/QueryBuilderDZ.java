package org.example.lesson2_ReflectionApi.DZ.task2;

import java.lang.reflect.Field;
import java.util.UUID;

public class QueryBuilderDZ {

    /**
     * TODO: Доработать метод Delete в рамках выполнения домашней работы
     *
     * @return
     */
    public String buildDeleteQuery(Class<?> clazz, UUID primaryKey) {
        StringBuilder query = new StringBuilder("DELETE FROM ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" WHERE ");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    if (columnAnnotation.primaryKey()) {
                        query.append(columnAnnotation.name()).append(" = ").append(primaryKey);
                        break;
                    }
                }
            }
        }

        return query.toString();
    }
}



