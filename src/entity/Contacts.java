package entity;

import java.time.LocalDate;

public class Contacts {
    private long userId;
    private long contactId;
    private LocalDate createdAt;

    public Contacts() {
    }

    public Contacts(long userId, long contactId, LocalDate createdAt) {
        setUserId(userId);
        setContactId(contactId);
        setCreatedAt(createdAt);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}