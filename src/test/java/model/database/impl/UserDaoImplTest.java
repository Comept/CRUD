package model.database.impl;

import entity.User;
import exception.DaoException;
import model.database.ConnectionBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserDaoImplTest {

    private UserDaoImpl userDao;
    private Session session;
    private Transaction transaction;

    @BeforeEach
    public void setUp() {
        userDao = new UserDaoImpl();
        session = mock(Session.class);
        transaction = mock(Transaction.class);

        // Настраиваем ConnectionBuilder, чтобы возвращать mock session
        ConnectionBuilder.setSessionFactory(mock(SessionFactory.class));
        when(ConnectionBuilder.getSessionFactory().openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void testFindUserById() throws DaoException {
        UUID userId = UUID.randomUUID();
        User mockUser = new User();
        mockUser.setId(userId);

        // Мокируем Query и поведение session для findUserById
        Query<User> query = mock(Query.class);
        when(session.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)).thenReturn(query);
        when(query.setParameter("id", userId)).thenReturn(query);
        when(query.uniqueResult()).thenReturn(mockUser);

        // Выполняем метод
        User result = userDao.findUserById(userId);

        // Проверка результата и вызовов
        assertNotNull(result);
        assertEquals(userId, result.getId());
        verify(transaction).commit();
    }

    @Test
    public void testFindUserByEmail() throws DaoException {
        String email = "test@example.com";
        User mockUser = new User();
        mockUser.setEmail(email);

        // Мокируем Query и поведение session для findUserByEmail
        Query<User> query = mock(Query.class);
        when(session.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)).thenReturn(query);
        when(query.setParameter("email", email)).thenReturn(query);
        when(query.uniqueResult()).thenReturn(mockUser);

        // Выполняем метод
        User result = userDao.findUserByEmail(email);

        // Проверка результата и вызовов
        assertNotNull(result);
        assertEquals(email, result.getEmail());
        verify(transaction).commit();
    }

    @Test
    public void testFindUserByUsername() throws DaoException {
        String username = "testUser";
        User mockUser = new User();
        mockUser.setUsername(username);

        // Мокируем Query и поведение session для findUserByUsername
        Query<User> query = mock(Query.class);
        when(session.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)).thenReturn(query);
        when(query.setParameter("username", username)).thenReturn(query);
        when(query.uniqueResult()).thenReturn(mockUser);

        // Выполняем метод
        User result = userDao.findUserByUsername(username);

        // Проверка результата и вызовов
        assertNotNull(result);
        assertEquals(username, result.getUsername());
        verify(transaction).commit();
    }

    @Test
    public void testSaveUser() throws DaoException {
        User user = new User();
        user.setUsername("newUser");

        // Выполняем метод
        userDao.saveUser(user);

        // Проверка вызова persist и commit
        verify(session).persist(user);
        verify(transaction).commit();
    }

    @Test
    public void testFindUserWithChatsById() throws DaoException {
        UUID userId = UUID.randomUUID();
        User mockUser = new User();
        mockUser.setId(userId);

        // Мокируем Query и поведение session для findUserWithChatsById
        Query<User> query = mock(Query.class);
        when(session.createQuery(anyString(), eq(User.class))).thenReturn(query);
        when(query.setParameter("id", userId)).thenReturn(query);
        when(query.uniqueResult()).thenReturn(mockUser);

        // Выполняем метод
        User result = userDao.findUserWithChatsById(userId, 10);

        // Проверка результата и вызовов
        assertNotNull(result);
        assertEquals(userId, result.getId());
        verify(transaction).commit();
    }
}
