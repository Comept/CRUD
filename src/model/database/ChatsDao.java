package model.database;

import entity.Messages;

import java.sql.SQLException;
import java.util.List;

public interface ChatsDao {
    List<Messages> findAllMessages(Long chatId) throws SQLException;
    void addMessage(Messages message);
}
