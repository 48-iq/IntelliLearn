package ru.deadline.destroers.intellilearn.dto;

import lombok.*;
import ru.deadline.destroers.intellilearn.enums.Role;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private Role role;

}
