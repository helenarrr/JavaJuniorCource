package org.example.lesson1_StreamApi.lecture;

import org.example.lesson1_StreamApi.lecture.User;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> list = Arrays.asList(new User("Павел", 20), new User("Аркадий", 79));

        list.stream().map(user -> new User(user.name,  user.age - 5))
                .filter(user -> user.age <= 25)
                .forEach(System.out::println);
    }
}