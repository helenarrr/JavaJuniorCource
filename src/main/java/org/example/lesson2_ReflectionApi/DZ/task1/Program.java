package org.example.lesson2_ReflectionApi.DZ.task1;


//Задача 1:
//Создайте абстрактный класс "Animal" с полями "name" и "age".
//Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

//Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:

//Выведите на экран информацию о каждом объекте.

//Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.

public class Program {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal[] animals = new Animal[3];
        animals[0] = new Cat();
        animals[1] = new Dog();

        Class<?> clazz1 = animals[0].getClass();
        System.out.println("Имя класса 1 " + clazz1);
        Class<?> clazz2 = animals[1].getClass();
        System.out.println("Имя класса 2" + clazz2);
        System.out.println();

        System.out.println("Поля класса 1: " + Arrays.toString(clazz1.getDeclaredFields()));
        System.out.println("Поля класса 2: " + Arrays.toString(clazz2.getDeclaredFields()));
        System.out.println();

        System.out.println("Родительский класс 1 класса: " + clazz1.getSuperclass());
        System.out.println("Родительский класс 2 класса: " + clazz2.getSuperclass());
        System.out.println();

        System.out.println("Методы 1 класса: " + Arrays.toString(clazz1.getDeclaredMethods()));
        System.out.println("Методы 2 класса: " + Arrays.toString(clazz2.getDeclaredMethods()));
        System.out.println();

        System.out.println("Конструкторы 1 класса: " + Arrays.toString(clazz1.getConstructors()));
        System.out.println("Конструкторы 2 класса: " + Arrays.toString(clazz2.getConstructors()));
        System.out.println();

        try {
            Method makeSound1 = animals[0].getClass().getDeclaredMethod("makeSound");
            makeSound1.setAccessible(true);
            makeSound1.invoke(animals[0]);
        } catch (Exception e) {
            System.out.println("Error 1...");
        }

        try {
            Method makeSound2 = animals[1].getClass().getDeclaredMethod("makeSound");
            makeSound2.setAccessible(true);
            makeSound2.invoke(animals[1]);

        } catch (Exception e) {
            System.out.println("Error 2...");
        }
    }
}
