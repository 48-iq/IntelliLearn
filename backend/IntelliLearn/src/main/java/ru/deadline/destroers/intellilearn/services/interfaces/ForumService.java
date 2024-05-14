package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Answer;
import ru.deadline.destroers.intellilearn.entities.Forum;

public interface ForumService {
    Forum createForum(Forum forum);

    Forum updateForum(Forum forum);

    Forum getForum(String forumId);

    void deleteForum(String forumId);
    void sendAnswer(String forumId, Answer answer);

}
