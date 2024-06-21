package model.database.my_orm;

import entity.Messages;
import exception.DaoException;
import model.database.ChatsDao;
import model.database.ConnectionBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChatsDaoImpl implements ChatsDao {
    private static final String ADD_CHAT = "INSERT INTO chats (chat_name, is_group) VALUES (?,?);";
    private static final String FIND_NAME = "SELECT chat_name FROM chats WHERE chat_id = ?;";
    private static final String IS_GROUP = "SELECT is_group FROM chats WHERE chat_id = ?";

    private static Connection getConnectiont() throws SQLException {
        return ConnectionBuilder.getConnection();
    }
    public void addChat(String chatName, boolean isGroup) throws DaoException {
        try(Connection con = getConnectiont();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_CHAT)) {
            preparedStatement.setString(1,chatName);
            preparedStatement.setBoolean(2,isGroup);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new DaoException(sqlException);
        }
    }
    public String findChatName(long chatId) throws DaoException{
        try(Connection con = getConnectiont();
        PreparedStatement preparedStatement = con.prepareStatement(FIND_NAME)) {
        preparedStatement.setLong(1,chatId);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            return rs.getString(1);
        }
        } catch (SQLException sqlException) {
            throw new DaoException(sqlException);
        }
        return null;
    }
    public boolean isGroup(long chatId) throws DaoException{
        try(Connection con = getConnectiont();
        PreparedStatement preparedStatement = con.prepareStatement(IS_GROUP);) {
            preparedStatement.setLong(1,chatId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                return rs.getBoolean(1);
            }
        } catch (SQLException sqlException) {
            throw new DaoException(sqlException);
        }
        return false;
    }
}
