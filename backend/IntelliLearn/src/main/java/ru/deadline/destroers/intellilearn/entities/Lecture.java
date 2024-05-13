package ru.deadline.destroers.intellilearn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "lector_id", referencedColumnName = "id")
    private User lector;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
