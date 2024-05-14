package ru.deadline.destroers.intellilearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.deadline.destroers.intellilearn.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
