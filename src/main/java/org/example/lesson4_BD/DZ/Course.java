package org.example.lesson4_BD.DZ;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Courses")
@NoArgsConstructor
@Data
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private String duration;

    public Course(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }
}
