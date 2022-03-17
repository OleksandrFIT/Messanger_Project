package messanger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import messanger.model.User;
import messanger.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public User findByUserId(@PathVariable("id") int id) {
        return userService.findByUserId(id);
    }

    @GetMapping("/users/by-phone/{phoneNumber}")
    public User findByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return userService.findUserByPhoneNumber(phoneNumber);
    }

    @GetMapping("/users/by-name/{userName}")
    public List<User> findByUserName(@PathVariable("userName") String userName) {
        return userService.findUserByUserName(userName);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody User user) {
        userService.createUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}
