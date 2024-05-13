package ru.deadline.destroers.intellilearn.dto;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
}
