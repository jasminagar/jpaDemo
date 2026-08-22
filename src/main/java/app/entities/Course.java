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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Person> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
