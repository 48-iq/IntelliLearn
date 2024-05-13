package ru.deadline.destroers.intellilearn.dto;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
public class AuthDto {
    private String username;
    private String password;
}
