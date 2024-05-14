package ru.deadline.destroers.intellilearn.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.deadline.destroers.intellilearn.enums.Role;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "userr")
public class User implements UserDetails {
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
    @OneToMany
    private List<Task> taskList;

    @ManyToMany(mappedBy = "recipients")
    private List<Notification> notificationList ;

    //user details
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public void addTask(Task task){
        taskList.add(task);
    }
}
