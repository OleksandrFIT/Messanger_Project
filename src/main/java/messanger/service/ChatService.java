package messanger.service;

import messanger.model.Chat;
import messanger.model.Message;
import messanger.model.User;

import java.util.List;

public interface ChatService {
    Chat createChat(List<User> users);

    void addUserToTheChat(User user, Chat chat);

    void addMessageToTheChat(Message message, Chat chat);

    void deleteChat(Chat chat);
}
