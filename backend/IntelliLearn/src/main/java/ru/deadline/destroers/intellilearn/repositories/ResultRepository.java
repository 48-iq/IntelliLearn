package ru.deadline.destroers.intellilearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.deadline.destroers.intellilearn.entities.Result;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findAllByTaskId(Long taskId);
}
