package ru.deadline.destroers.intellilearn.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Subject;
import ru.deadline.destroers.intellilearn.exceptions.NoSuchUserException;
import ru.deadline.destroers.intellilearn.repositories.SubjectRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.SubjectService;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(Subject subject) {
        Optional<Subject> existingSubject = subjectRepository.findById(subject.getId());
        if (existingSubject.isPresent()) {
            return subjectRepository.save(subject);
        } else {
            throw new NoSuchUserException("Subject not found in subject repository");
        }
    }

    @Override
    public Subject getSubject(Long subjectId) {
        return subjectRepository.findById(subjectId).orElseThrow(() -> new NoSuchElementException("Subject not found in subject repository"));
    }

    @Override
    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }

    @Override
    public Subject getSubjectByName(String name) {
        return subjectRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("Subject not found in subject repository"));
    }
}
