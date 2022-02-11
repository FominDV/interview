package entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    String name;

    @Column(name = "MARK")
    Integer mark;

    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

}
