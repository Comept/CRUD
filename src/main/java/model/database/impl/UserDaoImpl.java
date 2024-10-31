package model.database.impl;

import entity.User;
import exception.DaoException;
import model.database.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public String findUserPassword(String email) throws DaoException {
        return "";
    }

    @Override
    public User findUserByEmail(String email) throws DaoException {
        return new User();
    }

    @Override
    public User findUserByUsername(String username) throws DaoException {
        return new User();
    }

    @Override
    public void addUser(User user) throws DaoException {

    }
}
