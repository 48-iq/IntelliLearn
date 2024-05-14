package ru.deadline.destroers.intellilearn.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Group;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.exceptions.NoSuchGroupElement;
import ru.deadline.destroers.intellilearn.exceptions.NoSuchUserException;
import ru.deadline.destroers.intellilearn.repositories.GroupRepository;
import ru.deadline.destroers.intellilearn.repositories.UserRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.GroupService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group updateGroup(Group group) {
        Optional<Group> existingGroup = groupRepository.findById(group.getId());
        if (existingGroup.isPresent()) {
            return groupRepository.save(group);
        } else {
            throw new NoSuchGroupElement("Group not found in repository");
        }
    }

    @Override
    public Group getGroup(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(() -> new NoSuchGroupElement("Group not found in repository"));
    }

    @Override
    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }

    @Override
    public void addUserToGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new NoSuchGroupElement("Group not found in repository"));
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchUserException("User not found in repository"));
        group.getStudentList().add(user);
        groupRepository.save(group);
    }

    @Override
    public void removeUserFromGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new NoSuchGroupElement("Group not found in repository"));
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchUserException("User not found in repository"));
        group.getStudentList().remove(user);
        groupRepository.save(group);
    }
}
