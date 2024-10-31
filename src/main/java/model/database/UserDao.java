package model.database;


import entity.User;
import exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    String findUserPassword(String email) throws DaoException;
    User findUserByEmail(String email) throws DaoException;
    User findUserByUsername(String username) throws DaoException;
    void addUser(User user) throws DaoException;
}
