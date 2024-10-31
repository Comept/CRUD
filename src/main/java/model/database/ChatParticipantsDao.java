package model.database;

import entity.Chat;
import entity.ChatParticipants;
import entity.User;
import exception.DaoException;

import java.util.List;

public interface ChatParticipantsDao {
 void saveParticipant(ChatParticipants chatParticipants) throws DaoException;
 void deleteParticipant(ChatParticipants chatParticipants) throws DaoException;
 List<ChatParticipants> findChatParticipants(Chat chat) throws DaoException;
}
