package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Subject;

public interface SubjectService {

    Subject createSubject(Subject subject);

    Subject updateSubject(Subject subject);

    Subject getSubject(String subjectId);

    void deleteSubject(String subjectId);

    Subject getSubjectByName(String name);
}
