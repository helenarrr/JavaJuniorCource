package org.example.lesson3_Serialization.Seminar.DZ;

import java.io.Serializable;

public class Student implements Serializable {

    String name;
    int age;
    transient double GPA; // Поле не сериализируется, так как помечено как "transient"
    //transient — это модификатор, указываемый перед полем класса (подобно другим модификаторам, таким как public, final и т.д.)
    //для обозначения того, что данное поле не должно быть сериализовано.

    Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}
