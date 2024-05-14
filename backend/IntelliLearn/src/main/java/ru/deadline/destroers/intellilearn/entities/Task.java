package ru.deadline.destroers.intellilearn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Lob
    @Column(name = "file",columnDefinition = "BLOB")
    private byte[] file;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToMany
    private List<User> studentsList;
}
