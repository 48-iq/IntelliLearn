package ru.deadline.destroers.intellilearn.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "task_result")
public class TaskResult {
    private Long id;

    private List<Integer> grades;
}
