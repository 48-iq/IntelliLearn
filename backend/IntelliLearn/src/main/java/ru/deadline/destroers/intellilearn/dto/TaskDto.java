package ru.deadline.destroers.intellilearn.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.deadline.destroers.intellilearn.entities.User;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private byte[] file;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
