package model.database.impl;

import entity.User;
import exception.DaoException;
import model.database.ConnectionBuilder;
import model.database.UserDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.UUID;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUserById(UUID id) throws DaoException {
        User user;
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
            query.setParameter("id", id);
            user = query.uniqueResult();

            transaction.commit();
       }catch (Exception e){
           throw new DaoException(e);
       }
        return user;
    }

    @Override
    public User findUserByEmail(String email) throws DaoException {
        User user;
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            user = query.uniqueResult();

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
        return user;
    }

    @Override
    public User findUserByUsername(String username) throws DaoException {
        User user;
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            user = query.uniqueResult();

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
        return user;
    }

    @Override
    public User findUserWithChatsById(UUID id, Integer numOfMessages) throws DaoException {
        User user;
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<User> query = session
                    .createQuery(
                            "SELECT u FROM User u " +
                                    "LEFT JOIN FETCH u.chats c" +
                                    "LEFT JOIN FETCH c.messages " +
                                    "WHERE u.id = :id AND m.sentedAt = ( " +
                                    "   SELECT MAX(m2.timestamp) " +
                                    "       FROM Message m2 WHERE m2.chat.id = c.id" +
                                    "   )",
                            User.class);
            query.setParameter("id", id);
            user = query.uniqueResult();

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
        return user;
    }

    @Override
    public void saveUser(User user) throws DaoException {
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(user);

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }
}
