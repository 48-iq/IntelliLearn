package ru.deadline.destroers.intellilearn.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class StatusDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
}
