package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Message{
    @Id
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private UUID id;
    @ManyToOne
    private Chat chat;
    @ManyToOne
    private User user;
    private String messageText;
    @Builder.Default
    private Date sentedAt = new Date();

}