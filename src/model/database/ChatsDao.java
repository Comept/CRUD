package model.database;

import entity.Messages;
import exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface ChatsDao {
    void addChat(String chatName, boolean isGroup) throws DaoException;
    String findChatName(long chatId) throws DaoException;
    boolean isGroup(long chatId) throws DaoException;
}
