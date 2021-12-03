package messanger.service;

import messanger.model.User;

import java.util.List;

public interface UserService {

   void createUser(User user);

   void deleteUser(User user);

   void updateUser(User user);

   User findUserByPhoneNumber(String phoneNumber);

   User findByUserId(int id);
}
