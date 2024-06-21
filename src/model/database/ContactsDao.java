package model.database;

import entity.Contacts;
import exception.DaoException;

import java.util.ArrayList;

public interface ContactsDao {
    void addContact(long userId,long contactId) throws DaoException;
    ArrayList<Contacts> findAllContacts(long userId) throws DaoException;
}
