package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor()
@Builder
@Entity
@Table(name="users")
public class User implements Serializable{

    @Serial
    private static final long serialVersionUID = -6462501874197322250L;
    @Id
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private UUID id = UUID.randomUUID();
    @Column(unique=true, nullable = false)
    private String username;
    @Column(unique=true, nullable = false)
    private String email;
    @Builder.Default
    private List<String> grantedAuthority = new ArrayList<String>(List.of("USER_ROLE"));
    @Builder.Default
    private Date createdAt = new Date();

    @Builder.Default
    @OneToMany(mappedBy="user")
    private List<ChatParticipants> chats = new ArrayList<ChatParticipants>();

    @Builder.Default
    @OneToMany(mappedBy="user1Id")
    private List<Contacts> contacts = new ArrayList<Contacts>();

    public User(UUID id) {
        super();
        this.id = id;
    }

    public void addGrantedAuthority(String grantedAuthority) {
        if(!this.grantedAuthority.contains(grantedAuthority))
            this.grantedAuthority.add(grantedAuthority);
    }
    public void deleteGrantedAuthority(String grantedAuthority) {
        this.grantedAuthority.remove(grantedAuthority);
    }
    public User(UUID id, String username, String email, Date createdAt) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }
}