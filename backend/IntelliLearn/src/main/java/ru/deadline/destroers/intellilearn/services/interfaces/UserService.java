package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.User;

public interface UserService {
    User createUser(User user);

    User updateUser(User user);

    User getUser(Long userId);

    void deleteUser(Long userId);
}
