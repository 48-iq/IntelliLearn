package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Status;

import java.util.List;

public interface StatusService {
    Status createStatus(Status status);

    void pinStatusToUser(Long statusId, Long userId);

    void unpinStatusFromUser(Long statusId, Long userId);

    void deleteStatus(Long statusId);
    List<Status> getAllUsersStatuses(Long userId);
}
