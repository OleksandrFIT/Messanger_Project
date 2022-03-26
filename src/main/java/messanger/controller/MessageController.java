package messanger.controller;

import messanger.model.Chat;
import messanger.model.Message;
import messanger.model.User;
import messanger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Vadym: it should be named "MessageController"
//@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMessage(@RequestBody String messageText, int userId, int chatId) {
        messageService.sendMessage(messageText, userId, chatId);
    }

    @PutMapping("/messages")
    public void editMessage(@RequestBody Message message) {

        messageService.editMessage(message);
    }

    @GetMapping("/messages/by-id/{userId}")
    public ResponseEntity<List<Message>> findByUserId(@PathVariable("userId") int userId) {
        List<Message> messages = messageService.messagesByUserId(userId);
        if (messages.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

//    @GetMapping("/messages/by-id/{userId}")
//    public List<Message> findByUserId(@PathVariable("userId") int userId) {
//        return messageService.messagesByUserId(userId);
//
//
//    }

    @DeleteMapping("/messages/{id}")
    public void delete(@PathVariable("id") int id) {
        messageService.deleteMessage(id);
    }


}
