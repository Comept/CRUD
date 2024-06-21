package model.database;

import entity.Messages;
import exception.DaoException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MessagesDao {
    ArrayList<Messages> findAllMessages(long chatId) throws DaoException;
    void addMessage(long chatId, long sendId, String messageText) throws DaoException;
}
