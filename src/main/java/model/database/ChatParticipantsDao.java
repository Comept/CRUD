package model.database;

import exception.DaoException;

public interface ChatParticipantsDao {
 void addParticipant(long chatId, long userId, String role) throws DaoException;
 void deleteParticipant(long chatId, long userId) throws DaoException;
}
