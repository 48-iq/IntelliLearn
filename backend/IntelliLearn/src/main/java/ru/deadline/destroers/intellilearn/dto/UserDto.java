package ru.deadline.destroers.intellilearn.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
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
    private String password;
    private String email;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private Role role;

}
