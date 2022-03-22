package messanger.service;

import messanger.model.User;

import java.util.List;

public interface UserService {

   void createUser(User user);

   void deleteUser(int id);

   void updateUser(User user);

   User findUserByPhoneNumber(String phoneNumber);

   List<User> findUserByUserName(String userName);

   User findByUserId(int id);
}
