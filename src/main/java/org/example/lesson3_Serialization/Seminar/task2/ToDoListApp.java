package org.example.lesson3_Serialization.Seminar.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ToDoListApp {
    public static final String FILE_JSON = "tasks.json";
    public static final String FILE_BIN = "tasks.bin";
    public static final String FILE_XML = "tasks.xml";

    private static final ObjectMapper objMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void saveTasksToFile(String filename, List<ToDoV2> tasks) throws IOException {
        try {
            if (filename.endsWith(".json")) {
                objMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objMapper.writeValue(new File(filename), tasks);
            } else if (filename.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                    oos.writeObject(tasks);
                }
            } else if (filename.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(filename), tasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
