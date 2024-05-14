package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.User;

public interface RegistrationService {
    User register(User user);
    void delete(Long userId);
}
