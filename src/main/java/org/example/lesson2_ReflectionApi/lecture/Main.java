package org.example.lesson2_ReflectionApi.lecture;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> car = Class.forName("org.example.lesson2_ReflectionApi.lecture.Car");
        Constructor<?>[] constructors = car.getConstructors();
        System.out.println(constructors);

        Object gaz = constructors[0].newInstance("ГАЗ");
        System.out.println(gaz);


        Field[] fields = gaz.getClass().getFields();
        int tmp = fields[fields.length-1].getInt(gaz);
        fields[fields.length-1].setInt(gaz, tmp * 2);

        System.out.println(gaz);
    }


}
