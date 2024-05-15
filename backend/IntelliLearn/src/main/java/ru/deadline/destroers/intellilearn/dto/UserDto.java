package ru.deadline.destroers.intellilearn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String groupName;
    private String role;
}
