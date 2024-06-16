import java.time.LocalDate;

public class ChatParticipants {
    private long chatId;
    private long userId;
    private String role;
    private LocalDate joinedAt;

    public ChatParticipants() {
    }

    public ChatParticipants(long chatId, long userId, String role, LocalDate joinedAt) {
        setChatId(chatId);
        setUserId(userId);
        setRole(role);
        setJoinedAt(joinedAt);
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDate joinedAt) {
        this.joinedAt = joinedAt;
    }
}