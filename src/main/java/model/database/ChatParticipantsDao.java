package model.database;

import entity.Chat;
import entity.User;
import exception.DaoException;

public interface ChatParticipantsDao {
 void addParticipant(Chat chat, User user, String role) throws DaoException;
 void deleteParticipant(Chat chat, User user) throws DaoException;
}
