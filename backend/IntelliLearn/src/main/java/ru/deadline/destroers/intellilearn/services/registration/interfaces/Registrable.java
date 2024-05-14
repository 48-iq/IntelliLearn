package ru.deadline.destroers.intellilearn.services.registration.interfaces;

import ru.deadline.destroers.intellilearn.entities.User;

public interface Registrable {
    User register(User user);
    void delete(Long userId);
}
