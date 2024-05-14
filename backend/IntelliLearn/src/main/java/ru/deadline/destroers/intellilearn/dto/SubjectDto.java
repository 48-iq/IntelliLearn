package ru.deadline.destroers.intellilearn.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SubjectDto {
    private Long id;
    private String title;
    private Long lectorId;
    private String description;
}
