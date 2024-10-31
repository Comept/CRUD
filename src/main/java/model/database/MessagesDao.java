package model.database;

import entity.Chat;
import entity.Message;
import entity.User;
import exception.DaoException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MessagesDao {
    ArrayList<Message> findAllMessages(User chat) throws DaoException;
    void addMessage(Chat chat, User sender, String messageText) throws DaoException;
}
