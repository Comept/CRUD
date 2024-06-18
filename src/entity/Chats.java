package entity;

public class Chats {

  private long chatId;
  private String chatName;
  private float isGroup;

    public Chats() {
    }

    public Chats(long chatId, String chatName, float isGroup) {
        setChatId(chatId);
        setChatName(chatName);
        setIsGroup(isGroup);
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public float getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(float isGroup) {
        this.isGroup = isGroup;
    }
}