package ru.deadline.destroers.intellilearn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private List<User> students;

    @ManyToMany
    @JoinTable(name = "courses_directions",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "direction_id", referencedColumnName = "id")
    )
    private List<Course> courses;
}
