package org.example.lesson1_StreamApi.dz;

import java.util.Arrays;
import java.util.List;

import static org.example.lesson1_StreamApi.dz.TheNumberHandler.handlerNumbers;

public class Main {

    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(2, 3, 6, 8);

        handlerNumbers(arrayList);
    }
}
