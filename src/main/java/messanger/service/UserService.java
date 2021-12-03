package messanger.service;

import messanger.model.User;

public interface UserService {

   void createUser(User user);

   void deleteUser(User user);

   void updateUser(User user);

   User findUserByPhoneNumber(String phoneNumber);
}
