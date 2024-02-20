package org.example.lesson2_ReflectionApi.DZ.task1;

public class Cat extends Animal {

    private String voice;

    private void go() {

    }

    @Override
    public String toString() {
        return "Cat{" +
                "voice='" + voice + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
