package model.database.my_orm;

import entity.Messages;
import model.database.ChatsDao;
import model.database.ConnectionBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ChatsDaoImpl implements ChatsDao {

    private static final String FIND_ALL_MESSANGES = "";
    private static Connection getConnectiont() throws SQLException {
        return ConnectionBuilder.getConnection();
    }
    public List<Messages> findAllMessages(Long chatId) throws SQLException {
        try(Connection con = getConnectiont();
            PreparedStatement preparedStatement = con.prepareStatement(FIND_ALL_MESSANGES)){

        }
    return null;
    }

    public void addMessage(Messages message){

    };
}
