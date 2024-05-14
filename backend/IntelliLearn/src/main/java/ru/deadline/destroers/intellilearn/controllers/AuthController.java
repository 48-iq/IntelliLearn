package ru.deadline.destroers.intellilearn.controllers;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.deadline.destroers.intellilearn.dto.AuthDto;
import ru.deadline.destroers.intellilearn.dto.UserDto;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.repositories.UserRepository;
import ru.deadline.destroers.intellilearn.security.JwtUtil;
import ru.deadline.destroers.intellilearn.services.interfaces.RegistrationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RegistrationService registrationService;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        User user = registrationService.register(modelMapper.map(userDto, User.class));
        return ResponseEntity.ok(modelMapper.map(user, UserDto.class));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthDto authDto) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());

        try {
            authenticationManager.authenticate(authInputToken);
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Incorrect credentials!");
        }

        String token = jwtUtil.generateToken(userRepository.findByUsername(authDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found!")));
        return ResponseEntity.ok(token);
    }

}
