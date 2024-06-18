package entity;

import java.time.LocalDate;

public class Messages {
    private long messageId;
    private long chatId;
    private long senderId;
    private String messageText;
    private LocalDate sentAt;

    public Messages() {
    }

    public Messages(long messageId, long chatId, long senderId, String messageText, LocalDate sentAt) {
        setMessageId(messageId);
        setChatId(chatId);
        setSenderId(senderId);
        setMessageText(messageText);
        setSentAt(sentAt);
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public LocalDate getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDate sentAt) {
        this.sentAt = sentAt;
    }
}