package model.database.my_orm;

import entity.Messages;
import model.database.ChatsDao;
import model.database.ConnectionBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChatsDaoImpl implements ChatsDao {

    private static final String FIND_ALL_MESSANGES = "SELECT * FROM messages WHERE chat_id = ?";

    private static Connection getConnectiont() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    public ArrayList<Messages> findAllMessages(Long chatId) throws SQLException {
        ArrayList<Messages> messages = new ArrayList<Messages>();
        try (Connection con = getConnectiont();
             PreparedStatement preparedStatement = con.prepareStatement(FIND_ALL_MESSANGES)) {
            preparedStatement.setLong(1, chatId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                messages.add(new Messages(rs.getLong(1), rs.getLong(2), rs.getLong(3),
                        rs.getString(4), rs.getTime(5)));
            }
        }
        return messages;
    }

    public void addMessage(Messages message) {

    }

}
