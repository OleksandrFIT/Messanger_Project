package messanger.controller;

import messanger.model.Chat;
import messanger.model.User;
import messanger.service.ChatService;
import messanger.service.impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/chats")
    public ResponseEntity<List<Chat>>  findByChatTopic() {
       List<Chat> chats = chatService.findAll();
       if (chats.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

}
