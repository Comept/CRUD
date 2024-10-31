package model.database;

import entity.Contacts;
import entity.User;
import exception.DaoException;

import java.util.ArrayList;

public interface ContactsDao {
    void addContact(User user, User contact) throws DaoException;
    ArrayList<Contacts> findAllContacts(User user) throws DaoException;
}
