import entity.User;
import exception.DaoException;
import model.database.MessagesDao;
import model.database.impl.UserDaoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try {
            UserDaoImpl repo = new UserDaoImpl();
            repo.saveUser(new User(UUID.randomUUID(), "EWWED","FWEFFE",new Date()));
        } catch (DaoException e) {
            System.out.printf(e.getMessage());
        }

    }
}
