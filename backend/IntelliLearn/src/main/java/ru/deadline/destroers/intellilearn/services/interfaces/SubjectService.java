package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Subject;

public interface SubjectService {

    Subject createSubject(Subject subject);

    Subject updateSubject(Subject subject);

    Subject getSubject(Long subjectId);

    void deleteSubject(Long subjectId);

    Subject getSubjectByName(String name);
}
