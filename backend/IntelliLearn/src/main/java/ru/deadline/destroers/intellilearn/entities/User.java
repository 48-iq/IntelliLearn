package ru.deadline.destroers.intellilearn.Entities;

import jakarta.persistence.*;
import lombok.*;
import ru.deadline.destroers.intellilearn.enums.Role;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "userr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private Role role;
    @OneToMany(mappedBy = "owner")
    private List<Status> statusList;//this user received it
    @OneToMany(mappedBy = "creator")
    private List<Status> postedStatusList;//this user created it
}
