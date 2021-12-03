package messanger.controller;

import messanger.model.Chat;
import messanger.model.User;
import messanger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/by-id/{id}")
    public ResponseEntity<List<User>> findByUserId(@PathVariable("id") int id) {
        List<User> users = (List<User>) userService.findByUserId(id);
        if (users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
