package org.example.lesson1_StreamApi.seminar.Program2;

public class Chicken implements HealthyFood {
    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Курица";
    }
}
