package messanger.service.impl;

import messanger.model.Message;
import messanger.repository.MessageRepository;
import messanger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void sendMessage(String messageText, int userId, int chatId) {
        Message message = new Message();
        message.setMessageText(messageText);
        message.setMessageUserId(userId);
        message.setMessageChatId(chatId);
        message.setMessageDatetime(LocalDateTime.now().toString());
        messageRepository.save(message);
    }

    @Override
    public void deleteMessage(int messageId) {
        Message message = messageRepository.getById(messageId);
        messageRepository.delete(message);
    }

    @Override
    public void editMessage(Message message) {
        Message messageToUpdate = messageRepository.getById(message.getMessageId());
        messageToUpdate.setMessageText(message.getMessageText());
        messageToUpdate.setMessageUserId(message.getMessageUserId());
        messageToUpdate.setMessageChatId(message.getMessageChatId());
        messageToUpdate.setMessageDatetime(message.getMessageDatetime());
        messageRepository.save(messageToUpdate);
    }

    @Override
    public List<Message> messagesByUserId(int userId) {
        List<Message> messages = messageRepository.findByMessageUserId(userId);
        return messages;
    }
}
