package ru.deadline.destroers.intellilearn.dto;

import lombok.*;
import ru.deadline.destroers.intellilearn.entities.User;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto {
    private Integer id;
    private String name;
    private List<UserDto> students;
}
