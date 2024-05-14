package ru.deadline.destroers.intellilearn.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.repositories.UserRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.RegistrationService;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
