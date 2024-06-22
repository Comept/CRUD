package model.database.my_orm;

import entity.Messages;
import exception.DaoException;
import model.database.ConnectionBuilder;
import model.database.MessagesDao;

import java.sql.*;
import java.util.ArrayList;

public class MessagesDaoImpl implements MessagesDao {
    private static final String FIND_ALL_MESSANGES = "SELECT * FROM messages WHERE chat_id = ?";
    private static final String ADD_ADD_MESSAGE = "INSERT INTO meesages (chat_id, sender_id, message_text) VALUES (?,?,?);";

    private static Connection getConnectiont() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    public ArrayList<Messages> findAllMessages(long chatId) throws DaoException {
        ArrayList<Messages> messages = new ArrayList<Messages>();
        try (Connection con = getConnectiont();
             PreparedStatement preparedStatement = con.prepareStatement(FIND_ALL_MESSANGES)) {
            preparedStatement.setLong(1, chatId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                messages.add(new Messages(rs.getLong(1), rs.getLong(2), rs.getLong(3),
                        rs.getString(4), rs.getTime(5)));
            }
        } catch (SQLException sqlException) {
            throw new DaoException(sqlException);
        }
        return messages;
    }

    public void addMessage(long chatId, long sendId, String messageText) throws DaoException{
    try(Connection con = getConnectiont();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_ADD_MESSAGE)) {
        preparedStatement.setLong(1,chatId);
        preparedStatement.setLong(2,sendId);
        preparedStatement.setString(3,messageText);
        preparedStatement.executeUpdate();
    } catch (SQLException sqlException) {
        throw new DaoException(sqlException);
    }
    }
}
