package messanger;

import messanger.model.Chat;
import messanger.model.User;
import messanger.repository.UserRepository;
import messanger.service.ChatService;
import messanger.service.MessageService;
import messanger.service.UserService;
import messanger.service.impl.ChatServiceImpl;
import messanger.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application {

    @Autowired
    private static final    ChatService chatService = new ChatServiceImpl();
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
//        UserService userService = new UserServiceImpl();
        User user = new User();
//        user.setUserName("name1");
//        user.setPhoneNumber("+1234567890");
//        user.setBio("Some bio");

        Chat chat = new Chat();
        chat.setChatId(1);
        chat.setUsers(Set.of(user));
        chatService.createChat(List.of(user));
    }
}
