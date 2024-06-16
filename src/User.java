import java.time.LocalDate;

public class User {

    private long userId;
    private String userName;
    private String password;
    private String email;
    private LocalDate createdAt;

    public User(long userId, String userName, String password, String email, LocalDate createdAt) {
        setUserId(userId);
        setUserName(userName);
        setPassword(password);
        setEmail(email);
        setCreatedAt(createdAt);
    }

    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) /*throw*/{
        if(this.userId);
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) /*throw*/{
        if(this.userName);
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) /*throw*/{
        if(this.password);
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) /*throw*/{
        if(this.email);
        this.email = email;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) /*throw*/{
        if(this.createdAt);
        this.createdAt = createdAt;
    }

}