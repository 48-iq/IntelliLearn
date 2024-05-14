package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Subject;
import ru.deadline.destroers.intellilearn.entities.User;

public interface ProgressService {
    Progress getProgress(User user, Subject subject);
}
