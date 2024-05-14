package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Status;

public interface StatusService {
    // Create a new status
    Status createStatus(Status status);

    // Pin a status to a user
    void pinStatusToUser(String statusId, String userId);

    // Unpin a status from a user
    void unpinStatusFromUser(String statusId, String userId);

    // Delete a status by its ID
    void deleteStatus(String statusId);
}
