package model.database.my_orm;

import entity.User;
import model.database.ConnectionBuilder;
import model.database.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static final String FIND_PASSWORD = "SELECT password_hash FROM users WHERE email = ?";
    private static final String FIND_ID_BY_EMAIL = "SELECT user_id FROM users WHERE email = ?";
    private static final String FIND_ID_BY_USERNAME = "SELECT user_id FROM users WHERE username = ?";
    private static final String ADD_USSER = "INSERT INTO users (username, password_hash, email) VALUES (?, ?, ?)";
    private static Connection getConnectiont() throws SQLException {
        return ConnectionBuilder.getConnection();
    }
    public String findUserPassword(String email) {
        String password = null;
        try (Connection con = getConnectiont();
                PreparedStatement preparedStatement = con.prepareStatement(FIND_PASSWORD)) {
            preparedStatement.setString(1,email);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                password = rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return password;
    }
    public Long findUserIdByEmail(String email){
        long id = 0;
        try (Connection con = getConnectiont();
             PreparedStatement preparedStatement = con.prepareStatement(FIND_ID_BY_EMAIL)) {
            preparedStatement.setString(1,email);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                id = rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
    public Long findUserIdByUsername(String username){
        long id = 0;
        try (Connection con = getConnectiont();
             PreparedStatement preparedStatement = con.prepareStatement(FIND_ID_BY_USERNAME)) {
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                id = rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
    public void addUser(User user){
        try (Connection con = getConnectiont();
             PreparedStatement preparedStatement = con.prepareStatement(ADD_USSER)) {
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}