package messanger.repository;

import messanger.model.Message;
import messanger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

    List<Message> findByMessageText(String messageText);

    List<Message> findByMessageUserId(int userId);

}
