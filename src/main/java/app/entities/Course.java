package app.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Course {
    private @Id long id;
    private String name;

    public Course(String name) {
        this.name = name;
    }
}
