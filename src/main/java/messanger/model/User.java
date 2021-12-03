package messanger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Min(value = 1, message = "Id is not correct")
    private int userId;
    @Column(name = "user_name")
    @Max(value = 15, message = "Max length of the name should be less than 15")
    private String userName;
    @Column(name = "phone_number")
    @Size(min = 11, max = 11, message = "incorrect length")
    private String phoneNumber;
    @Column(name = "bio")
    @Max(value = 40, message = "Max length of the name should be less than 40")
    private String bio;

    @ManyToMany
    @JoinTable(
            name = "user_chat",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id"))
    private Set<Chat> chats;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Message> messages;

}
