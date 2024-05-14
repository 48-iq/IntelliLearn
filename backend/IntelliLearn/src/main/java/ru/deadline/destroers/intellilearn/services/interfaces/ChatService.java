package ru.deadline.destroers.intellilearn.services.interfaces;

public interface ChatService {
    Chat createChat(Chat chat);

    Chat updateChat(Chat chat);

    void addUserToChat(String chatId, String userId);

    void removeUserFromChat(String chatId, String userId);

    void deleteChat(String chatId);
}
