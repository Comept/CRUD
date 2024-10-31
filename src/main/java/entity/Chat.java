package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Chat {
    @Id
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private UUID id;
    private String chatName;
    private boolean isGroup;

    @Builder.Default
    @OneToMany(mappedBy = "chat")
    private List<ChatParticipants> chatParticipants = new ArrayList();

    @Builder.Default
    @OneToMany(mappedBy = "chat")
    private List<Message> messages = new ArrayList();

    public Chat(UUID id) {
        super();
        this.id = id;
    }
}