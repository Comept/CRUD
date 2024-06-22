import entity.Messages;
import entity.User;
import exception.DaoException;
import model.database.MessagesDao;
import model.database.my_orm.MessagesDaoImpl;
import model.database.my_orm.UserDaoImpl;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            UserDaoImpl userDao = new UserDaoImpl();
            User user = new User();
            user.setEmail("te2st@email.com");
            user.setPassword("asasdas");
            user.setUsername("weweew2");
            System.out.println(userDao.findUserPassword(user.getEmail()));
            System.out.println(userDao.findUserIdByEmail(user.getEmail()).toString());
            //userDao.addUser(user);
            MessagesDao chatsDao = new MessagesDaoImpl();
            ArrayList<Messages> res = chatsDao.findAllMessages(1L);
            Iterator<Messages> iterator = res.iterator();
            while (iterator.hasNext()) {
                Messages mes = iterator.next();
                System.out.printf("chatId - %d\n senderId - %d\n TEXT - %s\n", mes.getChatId(), mes.getSenderId(), mes.getMessageText());
            }
        } catch (DaoException e) {
            System.out.printf(e.getMessage());
        }

    }
}
