package messanger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {

        userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}
