package org.example.lesson3_Serialization.Seminar.DZ;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.lesson3_Serialization.Seminar.task2.ToDoV2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class StudentService {

    public static final String FILE_JSON = "students.json";
    public static final String FILE_BIN = "students.bin";
    public static final String FILE_XML = "students.xml";

    private static final ObjectMapper objMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void saveStudentsToSomeFile(String filename, List<Student> listStudent) throws IOException {
        try {
            if (filename.endsWith(".json")) {
                objMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objMapper.writeValue(new File(filename), listStudent);
            } else if (filename.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {

                    oos.writeObject(listStudent);
                }
            } else if (filename.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(filename), listStudent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
