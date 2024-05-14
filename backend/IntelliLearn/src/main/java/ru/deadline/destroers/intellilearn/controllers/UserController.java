package ru.deadline.destroers.intellilearn.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import ru.deadline.destroers.intellilearn.dto.UserDto;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.exceptions.UserNotFoundControllerException;
import ru.deadline.destroers.intellilearn.repositories.UserRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

//    @Autowired
    private UserService userService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(modelMapper.map(userService.getUser(id), UserDto.class));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(modelMapper.map(savedUser, UserDto.class));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userService.updateUser(user);
        return ResponseEntity.ok(modelMapper.map(savedUser, UserDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
