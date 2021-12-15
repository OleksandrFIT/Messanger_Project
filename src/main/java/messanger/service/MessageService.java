package messanger.service;

import messanger.model.Message;

import java.util.List;

public interface MessageService {

    void sendMessage(String messageText, int userId, int chatId);

    void deleteMessage(int messageId);

    void editMessage(Message message);

    List<Message> messagesByUserId(int userId);
    //comment for commit check
}
