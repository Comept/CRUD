package model.database;


import entity.User;
import exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public interface UserDao {
    User findUserById(UUID id) throws DaoException;
    User findUserByEmail(String email) throws DaoException;
    User findUserByUsername(String username) throws DaoException;
    User findUserWithChatsById(UUID id, Integer numOfMessages)
            throws DaoException;
    void saveUser(User user) throws DaoException;
}
