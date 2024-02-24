package org.example.lesson3_Serialization.Seminar.task1;

import java.io.*;

public class Program {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserData user = new UserData("Станислав", 31, "secret");

        try (FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
        {
            objectOutputStream.writeObject(user);
            System.out.println("Сериализация прошла успешно");
        }

        try (FileInputStream fileIn = new FileInputStream("userdata.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileIn))
        {
            user = (UserData) objectInputStream.readObject();
            System.out.println(user);
            System.out.println("Десериализация прошла успешно");
        }
    }
}
