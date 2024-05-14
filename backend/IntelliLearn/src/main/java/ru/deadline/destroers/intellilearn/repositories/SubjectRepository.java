package ru.deadline.destroers.intellilearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.deadline.destroers.intellilearn.entities.Subject;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findByName(String name);
}
