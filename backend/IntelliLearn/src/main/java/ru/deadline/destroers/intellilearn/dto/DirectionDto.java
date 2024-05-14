package ru.deadline.destroers.intellilearn.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DirectionDto {
    private Long id;
    private String name;
    private Long coursesList;
}
