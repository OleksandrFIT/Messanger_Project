package messanger.service.impl;

import messanger.model.Message;
import messanger.model.User;
import messanger.repository.UserRepository;
import messanger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
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
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public User findByUserId(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
