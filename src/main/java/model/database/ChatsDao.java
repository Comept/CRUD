package model.database;


import entity.Chat;
import exception.DaoException;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface ChatsDao {
    void saveChat(Chat chat) throws DaoException;
    Chat findbyChatname(String chatName) throws DaoException;
    Chat findbyId(UUID chatId) throws DaoException;
}
