package model.database.impl;

import entity.Chat;
import entity.ChatParticipants;
import entity.Message;
import entity.User;
import exception.DaoException;
import model.database.ConnectionBuilder;
import model.database.MessagesDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MessagesDaoImpl implements MessagesDao {
    @Override
    public List<Message> findAllMessages(Chat chat) throws DaoException {
        List<Message> message;
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Message> query = session.createQuery("SELECT m FROM Message m WHERE m.chat.id = :id", Message.class);
            query.setParameter("id", chat.getId());
            message = query.getResultList();

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
        return message;
    }

    @Override
    public void saveMessage(Message message) throws DaoException {
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(message);

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }
}
