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
@Table(name = "directions")
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private List<User> students;

    @ManyToMany(mappedBy = "directions")
    private List<Course> courses;
}
