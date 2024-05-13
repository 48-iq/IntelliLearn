package ru.deadline.destroers.intellilearn.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<User> studentList;

    @OneToOne
    @JoinColumn(name = "curator_id", referencedColumnName = "id")
    private User curator;
    private String name;
}
