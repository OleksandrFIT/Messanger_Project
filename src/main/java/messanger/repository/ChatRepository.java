package messanger.repository;


import messanger.model.Chat;
import messanger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer>{

    List<Chat> findByChatTopic(String chatTopic);


}
