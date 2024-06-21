package model.database.my_orm;

import exception.DaoException;
import model.database.ChatParticipantsDao;
import model.database.ConnectionBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChatParticipantsDaoImpl implements ChatParticipantsDao {

    private static final String ADD_PARTICIPANT = "INSERT INTO chatparticipants (chat_id, user_id, role) VALUES (?,?,?);";
    private  static final String DELETE_PARTICIOANT = "DELETE FROM chatparticipants WHERE chat_id = ? AND user_id = ?;";

    private static Connection getConnectiont() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    public void addParticipant(long chatId, long userId, String role) throws DaoException {
        try(Connection con = getConnectiont();
            PreparedStatement preparedStatement = con.prepareStatement(ADD_PARTICIPANT);) {
            preparedStatement.setLong(1,chatId);
            preparedStatement.setLong(2,userId);
            preparedStatement.setString(3,role);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new DaoException(sqlException);
        }
    }
    public void deleteParticipant(long chatId, long userId) throws DaoException{
        try(Connection con = getConnectiont();
        PreparedStatement preparedStatement = con.prepareStatement(DELETE_PARTICIOANT);){
            preparedStatement.setLong(1,chatId);
            preparedStatement.setLong(2,userId);
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException) {
            throw new DaoException(sqlException);
        }
    }
}
