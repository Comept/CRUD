package entity;

import java.time.LocalDate;

public class User {

    private Long userId;
    private String username;
    private String password;
    private String email;
    private LocalDate createdAt;

    public User(Long userId, String username, String password, String email, LocalDate createdAt) {
        setUserId(userId);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setCreatedAt(createdAt);
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) /*throw*/{
        if(this.userId == 0);
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) /*throw*/{
        if(this.username == null);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) /*throw*/{
        if(this.password == null);
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) /*throw*/{
        if(this.email == null);
        this.email = email;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) /*throw*/{
        if(this.createdAt == null);
        this.createdAt = createdAt;
    }

}