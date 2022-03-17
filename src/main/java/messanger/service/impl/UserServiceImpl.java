package messanger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import messanger.exception.EntityNotFoundException;
import messanger.model.User;
import messanger.repository.UserRepository;
import messanger.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = findByUserId(id);
        userRepository.delete(user);
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = userRepository.getById(user.getUserId());
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        userToUpdate.setBio(user.getBio());
        userRepository.save(userToUpdate);
    }

    @Override
    public User findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find a user with phone number=" + phoneNumber));
    }

    @Override
    public List<User> findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User findByUserId(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find a user with id=" + id));
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
