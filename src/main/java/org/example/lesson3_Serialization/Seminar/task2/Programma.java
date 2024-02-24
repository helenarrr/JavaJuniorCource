package org.example.lesson3_Serialization.Seminar.task2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.lesson3_Serialization.Seminar.task2.ToDoListApp.*;

public class Programma {

    public static void main(String[] args) throws IOException {
        List<ToDoV2> tasks;
        File file = new File(FILE_JSON);

        if (file.exists() && !file.isDirectory()) {

        } else {
            tasks = prepareTasks();
            saveTasksToFile(FILE_JSON, tasks);
            saveTasksToFile(FILE_BIN, tasks);
            saveTasksToFile(FILE_XML, tasks);

        }
    }

    static List<ToDoV2> prepareTasks() {
        ArrayList<ToDoV2> list = new ArrayList<>();
        list = new ArrayList<>();
        list.add(new ToDoV2("Сходить в магаз"));
        list.add(new ToDoV2("Сходить в школу"));
        list.add(new ToDoV2("Сходить в художку"));
        return list;
    }
}
