package model.database;

import entity.Contacts;
import entity.User;
import exception.DaoException;

import java.util.List;
import java.util.UUID;

public interface ContactsDao {
    void saveContact(Contacts contact) throws DaoException;
    List<Contacts> findUserContacts(User user) throws DaoException;
    List<Contacts> findUserContacts(UUID userId) throws DaoException;
}
