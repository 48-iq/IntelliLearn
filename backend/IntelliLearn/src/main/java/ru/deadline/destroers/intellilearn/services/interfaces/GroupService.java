package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Group;

public interface GroupService {
    Group createGroup(Group group);

    Group updateGroup(Group group);

    Group getGroup(String groupId);

    void deleteGroup(String groupId);

    void addUserToGroup(String groupId, String userId);

    void removeUserFromGroup(String groupId, String userId);
}
