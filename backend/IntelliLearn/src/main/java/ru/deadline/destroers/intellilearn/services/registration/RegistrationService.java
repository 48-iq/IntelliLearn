package ru.deadline.destroers.intellilearn.services.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.exceptions.NoSuchUserException;
import ru.deadline.destroers.intellilearn.exceptions.UserAlreadyExistException;
import ru.deadline.destroers.intellilearn.repositories.UserRepository;
import ru.deadline.destroers.intellilearn.services.registration.interfaces.Registrable;

@Service
public class RegistrationService implements Registrable {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExistException("User in database already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public void delete(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            throw new NoSuchUserException("Such user does not exist in database");
        }
    }
}
