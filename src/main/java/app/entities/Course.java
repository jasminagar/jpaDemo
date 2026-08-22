package app.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Teacher teacher;
    private int semester;
    private String classRoom;
    private LocalTime timeOfCourse;
    @ManyToMany(mappedBy = "courses")
    private List<Person> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }
}
