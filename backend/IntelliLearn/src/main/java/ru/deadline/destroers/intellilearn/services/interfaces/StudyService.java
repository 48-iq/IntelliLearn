package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Task;
import ru.deadline.destroers.intellilearn.entities.User;

public interface StudyService {
    void addReminder(StudyReminder studyReminder);

    void removeReminder(String reminderId);
}
