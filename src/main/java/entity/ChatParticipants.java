package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ChatParticipants implements Serializable {
    private static final long serialVersionUID = 5422110446816052268L;
    @Id
    private UUID id;

    @ManyToOne
    private Chat chat;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    private String role;
    private Date joinedAt;

    public ChatParticipants(UUID id) {
        super();
        this.id = id;
    }
}