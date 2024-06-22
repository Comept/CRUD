package model.database.my_orm;

import entity.Contacts;
import entity.User;
import exception.DaoException;
import model.database.ConnectionBuilder;
import model.database.ContactsDao;
import org.checkerframework.checker.units.qual.C;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactsDaoImpl implements ContactsDao {

    private static final String ADD_CONTACT = "INSERT INTO contacts (user_id, contact_id) VALUES (?,?);";
    private static final String FIND_ALL_CONTACTS = "SELECT * FROM contacts";

    private static Connection getConnectiont() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    public void addContact(long userId,long contactId) throws DaoException{
        try (Connection con = getConnectiont();
             PreparedStatement preparedStatement = con.prepareStatement(ADD_CONTACT);){
            preparedStatement.setLong(1,userId);
            preparedStatement.setLong(2,contactId);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new DaoException(sqlException);
        }
    }
    public ArrayList<Contacts> findAllContacts(long userId) throws DaoException {
        ArrayList<Contacts> res = new ArrayList<Contacts>();
        try(Connection con = getConnectiont();
            PreparedStatement preparedStatement = con.prepareStatement(FIND_ALL_CONTACTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                res.add(new Contacts(rs.getLong(1), rs.getLong(2)));
            }
        } catch (SQLException sqlException) {
            throw new DaoException(sqlException);
        }
        return res;
    }
}
