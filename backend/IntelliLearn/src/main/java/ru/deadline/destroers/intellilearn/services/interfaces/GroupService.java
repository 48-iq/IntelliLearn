package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Group;

public interface GroupService {
    Group createGroup(Group group);

    Group updateGroup(Group group);

    Group getGroup(Long groupId);

    void deleteGroup(Long groupId);

    void addUserToGroup(Long groupId, Long userId);

    void removeUserFromGroup(Long groupId, Long userId);
}
