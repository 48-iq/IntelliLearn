package ru.deadline.destroers.intellilearn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class SignInRequest {
    private String username;
    private String password;
}
