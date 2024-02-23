package org.example.lesson3_Serialization.Seminar.DZ;


import java.io.*;

//Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
//Обеспечьте поддержку сериализации для этого класса.
//Создайте объект класса Student и инициализируйте его данными.
//Сериализуйте этот объект в файл.
//Десериализуйте объект обратно в программу из файла.
//Выведите все поля объекта, включая GPA, и ответьте на вопрос,
//почему значение GPA не было сохранено/восстановлено.
public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Student student1 = new Student("Student1", 22, 4.3);

        FileOutputStream fileOutputStream = new FileOutputStream("student.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student1);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("student.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println( objectInputStream.readObject());
        objectInputStream.close();
    }



}


