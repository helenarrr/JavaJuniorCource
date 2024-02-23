package org.example.lesson3_Serialization.Seminar.DZ;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.lesson3_Serialization.Seminar.DZ.StudentService.*;

//Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
//Обеспечьте поддержку сериализации для этого класса.
//Создайте объект класса Student и инициализируйте его данными.
//Сериализуйте этот объект в файл.
//Десериализуйте объект обратно в программу из файла.
//Выведите все поля объекта, включая GPA, и ответьте на вопрос,
//почему значение GPA не было сохранено/восстановлено.
public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Student student1 = new Student("Student1", 22, 5);
        Student student2 = new Student("Student2", 22, 3);
        Student student3 = new Student("Student3", 22, 3);
        Student student4 = new Student("Student4", 22, 4);
        Student student5 = new Student("Student5", 22, 5);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);


        File file = new File(FILE_JSON);

        if (file.exists() && !file.isDirectory()) {

        }
        else {
            saveStudentsToSomeFile(FILE_JSON, students);
            saveStudentsToSomeFile(FILE_BIN, students);
            saveStudentsToSomeFile(FILE_XML, students);
        }



//        FileOutputStream fileOutputStream = new FileOutputStream("student.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(student1);
//        objectOutputStream.close();
//
//        FileInputStream fileInputStream = new FileInputStream("student.txt");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        System.out.println( objectInputStream.readObject());
//        objectInputStream.close();
    }



}


