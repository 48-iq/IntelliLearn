package ru.deadline.destroers.intellilearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.deadline.destroers.intellilearn.entities.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
