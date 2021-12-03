package messanger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    @Min(value = 1, message = "Chat id is not correct")
    private int chatId;
    @Column(name = "chat_topic")
    @Max(value = 15, message = "Max length of the ChatName should be less than 15")
    private String chatTopic;

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY)
    private List<Message> messages;

    @ManyToMany(mappedBy = "chats")
    private Set<User> users;

}
