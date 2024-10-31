package model.database.impl;

import entity.Chat;
import exception.DaoException;
import model.database.ChatsDao;
import model.database.ConnectionBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.UUID;

public class ChatDaoImpl implements ChatsDao {

    @Override
    public void saveChat(Chat chat) throws DaoException {
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(chat);

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public Chat findbyChatname(String chatName) throws DaoException {
        Chat chat;
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Chat> query = session.createQuery("SELECT c FROM Chat c WHERE c.chatName = :chatName", Chat.class);
            query.setParameter("chatName", chatName);
            chat = query.uniqueResult();

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
        return chat;
    }

    @Override
    public Chat findbyId(UUID chatId) throws DaoException {
        Chat chat;
        try (Session session = ConnectionBuilder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Chat> query = session.createQuery("SELECT c FROM Chat c WHERE c.id = :id", Chat.class);
            query.setParameter("id", chatId);
            chat = query.uniqueResult();

            transaction.commit();
        }catch (Exception e){
            throw new DaoException(e);
        }
        return chat;
    }
}
