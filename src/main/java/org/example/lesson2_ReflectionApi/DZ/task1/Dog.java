package org.example.lesson2_ReflectionApi.DZ.task1;

public class Dog extends Animal {

    private String length;

    private void run() {

    }

    private  void makeSound() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "length='" + length + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
