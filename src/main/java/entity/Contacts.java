package entity;

import jakarta.persistence.*;
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
public class Contacts implements Serializable {
    private static final long serialVersionUID = -1662860013574355705L;
    @Id
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user1_id", insertable = false, updatable = false)
    private User user1Id;
    @ManyToOne
    @JoinColumn(name = "user2_id", insertable = false, updatable = false)
    private User user2Id;
    private Date createdAt;
}