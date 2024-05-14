package ru.deadline.destroers.intellilearn.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto{
    private Long id;
    private String name;
    private List<UserDto> students;
    private List<Long> directionsList;
}
