package messanger.service.impl;

import messanger.model.Chat;
import messanger.model.Message;
import messanger.model.User;
import messanger.repository.ChatRepository;
import messanger.repository.UserRepository;
import messanger.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat createChat(List<User> users) {
        Chat chat = new Chat();
        chat.setUsers(new HashSet<>(users));
        return chatRepository.save(chat);

    }

    @Override
    public void addUserToTheChat(User user, Chat chat) {
        Set<User> users = chat.getUsers();
        users.add(user);
        chat.setUsers(users);
        chatRepository.save(chat);
    }

//    @Override
//    public void addMessageToTheChat(Message message, Chat chat) {
//        List<Message> messages = chat.getMessages();
//        messages.add(message);
//        chat.setMessages(messages);
//        chatRepository.save(chat);
//    }

    @Override
    public void deleteChat(int chatId) {
        Chat chat = chatRepository.getById(chatId);
        chatRepository.delete(chat);
    }



    @Override
    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    @Autowired
    public void setChatRepository(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }
}
