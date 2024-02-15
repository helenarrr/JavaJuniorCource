package org.example.lesson2_ReflectionApi.lecture;

public class Car {

    public String name;
    private String price;
    private String engType;
    private String endPower;
    private int maxSpeed;

    public Car(String name) {
        this.name = name;
        this.engType = "V8";
        this.endPower = "123";
        this.maxSpeed = 100;
        this.price = "100000";
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", engType='" + engType + '\'' +
                ", endPower='" + endPower + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
