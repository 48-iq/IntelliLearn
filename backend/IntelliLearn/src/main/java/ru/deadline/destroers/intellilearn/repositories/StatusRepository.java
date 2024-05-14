package ru.deadline.destroers.intellilearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.deadline.destroers.intellilearn.entities.Status;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Long> {
    List<Status> findByOwnerId(Long userId);
}
