package org.example.lesson1_StreamApi.dz;

import java.util.List;

public class TheNumberHandler {

//    Напишите программу, которая использует
//    Stream API для обработки списка чисел. Программа должна вывести на экран среднее значение всех четных чисел в списке.

    public static void handlerNumbers(List<Integer> listNum) {
        double averageOfEvenNumbers = listNum.stream()
                .filter(number -> number % 2 == 0)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("среднее значение всех четных чисел в списке " + averageOfEvenNumbers);

    }
}
