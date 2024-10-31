package model.database.impl;

import entity.Chat;
import entity.ChatParticipants;
import entity.Contacts;
import entity.User;
import exception.DaoException;
import model.database.ChatParticipantsDao;
import model.database.ConnectionBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ChatParticipantsDaoImpl implements ChatParticipantsDao {

    @Override
    public void saveParticipant(ChatParticipants chatParticipants) throws DaoException {
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(chatParticipants);

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteParticipant(ChatParticipants chatParticipants) throws DaoException {
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.remove(chatParticipants);

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public List<ChatParticipants> findChatParticipants(Chat chat) throws DaoException {
        List<ChatParticipants> chatParticipants;
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<ChatParticipants> query = session.createQuery("SELECT cp FROM ChatParticipants cp WHERE cp.chat.id = :id", ChatParticipants.class);
            query.setParameter("id", chat.getId());
            chatParticipants = query.getResultList();

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
        return chatParticipants;
    }

}
