import entity.User;
import model.database.my_orm.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setEmail("te2st@email.com");
        user.setPassword("asasdas");
        user.setUsername("weweew2");
        System.out.println(userDao.findUserPassword(user.getEmail()));
        System.out.println(userDao.findUserIdByEmail(user.getEmail()).toString());
        userDao.addUser(user);
    }
}
