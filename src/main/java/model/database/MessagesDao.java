package model.database;

import entity.Chat;
import entity.Message;
import entity.User;
import exception.DaoException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MessagesDao {
    List<Message> findAllMessages(Chat chat) throws DaoException;
    void saveMessage(Message message) throws DaoException;
}
