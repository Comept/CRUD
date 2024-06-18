package model.database;


import entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    String findUserPassword(String email);
    Long findUserIdByEmail(String email);
    Long findUserIdByUsername(String username);
    void addUser(User user);
}
