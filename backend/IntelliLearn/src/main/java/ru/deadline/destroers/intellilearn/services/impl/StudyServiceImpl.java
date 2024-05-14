package ru.deadline.destroers.intellilearn.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Task;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.repositories.TaskRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.StudyService;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {
    private final TaskRepository taskRepository;
    @Override
    public void addReminder(StudyReminder studyReminder) {

    }

    @Override
    public void removeReminder(String reminderId) {

    }
}
