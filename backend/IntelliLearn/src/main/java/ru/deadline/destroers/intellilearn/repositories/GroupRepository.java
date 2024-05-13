package ru.deadline.destroers.intellilearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.deadline.destroers.intellilearn.entities.Group;
import ru.deadline.destroers.intellilearn.entities.User;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
