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
    @NotNull
    @Length(min = 3, max = 32)
    private String username;
    @Length(min = 8, max = 32)
    private String password;
    @Email
    private String email;
    @Length(min = 1)
    private String name;
    @Length(min = 1)
    private String surname;
    @Length(min = 1)
    private String patronymic;
    private LocalDate birthday;
    private Role role;

}
