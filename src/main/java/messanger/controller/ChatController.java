package messanger.controller;

import messanger.model.Chat;
import messanger.model.Message;
import messanger.model.User;
import messanger.service.ChatService;
import messanger.service.impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/chats")
    @ResponseStatus(HttpStatus.CREATED)
    public void createChat(@RequestBody List<User> users) {

        chatService.createChat(users);
    }
    @PutMapping("/chats")
    public void addUserToTheChat(@RequestBody User user, Chat chat) {

        chatService.addUserToTheChat(user, chat);
    }


//    @PostMapping("/messages")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addMessageToTheChat(@RequestBody Message message, Chat chat) {
//
//        chatService.addMessageToTheChat(message, chat);
//    }

    @GetMapping("/chats")
    public ResponseEntity<List<Chat>>  findByChatTopic() {
       List<Chat> chats = chatService.findAll();
       if (chats.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }


    @DeleteMapping("/chats/{id}")
    public void delete(@PathVariable("id") int id) {
        chatService.deleteChat(id);
    }

}
