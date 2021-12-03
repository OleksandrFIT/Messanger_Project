package messanger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    @Min(value = 1, message = "Message id is not correct")
    private int messageId;
    @Column(name = "message_datetime")
    private String messageDatetime;

    @Max(value = 100, message = "Max length of the message should be less than 100 letters")
    @Column(name = "message_text")
    private String messageText;

    @Min(value = 1, message = "Message chat id is not correct")
    @Column(name = "message_chat_id")
    private int messageChatId;

    @Min(value = 1, message = "Message user id is not correct")
    @Column(name = "message_user_id")
    private int messageUserId;

    @JoinColumn(name = "chat_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
