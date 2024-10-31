package model.database.impl;

import entity.Contacts;
import entity.User;
import exception.DaoException;
import model.database.ConnectionBuilder;
import model.database.ContactsDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class ContactsDaoImpl implements ContactsDao {

    @Override
    public void saveContact(Contacts contact) throws DaoException {
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(contact);

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public List<Contacts> findUserContacts(User user) throws DaoException {
        List<Contacts> contacts;
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Contacts> query = session.createQuery("SELECT c FROM Contacts c WHERE u.user1Id = :id", Contacts.class);
            query.setParameter("id", user.getId());
            contacts = query.getResultList();

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
        return contacts;
    }

    @Override
    public List<Contacts> findUserContacts(UUID userId) throws DaoException {
        List<Contacts> contacts;
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Contacts> query = session.createQuery("SELECT c FROM Contacts c WHERE u.user1Id = :id", Contacts.class);
            query.setParameter("id", userId);
            contacts = query.getResultList();

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
        return contacts;
    }
}
