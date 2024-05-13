package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.User;

public interface RegistrationService {
    User register(User user); // register user and return user (with the specified id)
    // may throw user already exist exception

}
