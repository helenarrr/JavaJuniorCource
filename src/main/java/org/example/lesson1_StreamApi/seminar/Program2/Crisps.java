package org.example.lesson1_StreamApi.seminar.Program2;

public class Crisps implements Snack {

    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Чипсы";
    }
}
