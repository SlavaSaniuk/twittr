package by.bsac.services;

import by.bsac.models.User;
import by.bsac.services.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Class implements User DAO interface.
 *  This is service which have a business logic of CRUD operations on user object in database.
 */
@Service("userDao")
public class UserDaoImpl implements UserDAO {

    /* Class global variables */
    private DataSource data_source; // Data source.
    private NamedParameterJdbcTemplate je; //JDBC Template (DAO engine).

    /* Class constructors */
    @Autowired
    public UserDaoImpl(DataSource data_source) {
        this.je = new NamedParameterJdbcTemplate(data_source);
    }

    /* Class methods */
    @Override
    public List<User> findAll() {

        //SQL statement syntax:
        String sql = "SELECT * FROM USER";

        //Return List<User>
        return this.je.query(sql, new UsersRowMapper());
    }

    @Override
    public User findByID(Integer a_id) {
        return null;
    }

    @Override
    public List<User> findByFirstName(String a_first_name) {

        //SQL statement syntax:
        String sql = "SELECT * FROM USER WHERE USER_FNAME = :FIRST_NAME;";

        //Map of named parameters to SQL statement:
        Map<String, Object> named_parameters = new HashMap<>();
        named_parameters.put("FIRST_NAME", a_first_name);

        //Return List<User>
        return this.je.query(sql, named_parameters, new UsersRowMapper() );
    }

    @Override
    public List<User> findByLastName(String a_last_name) {

        //SQL statement syntax:
        String sql = "SELECT * FROM USER WHERE USER_LNAME = :LAST_NAME;";

        //Map of named parameters to SQL statement:
        Map<String, Object> named_parameters = new HashMap<>();
        named_parameters.put("LAST_NAME", a_last_name);

        //Return List<User>
        return this.je.query(sql, named_parameters, new UsersRowMapper() );
    }

    @Override
    public User findByEmail(String a_email) {
        return null;
    }

    @Override
    public void create(User a_user) {

    }

    @Override
    public void update(User a_user) {

    }

    @Override
    public void delete(User a_user) {

    }

    private static class UsersRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setUserId(resultSet.getInt("USER_ID"));
            user.setUserEmail(resultSet.getString("USER_EMAIL"));
            user.setUserPassword(resultSet.getString("USER_PASSWORD"));
            user.setFirstName(resultSet.getString("USER_FNAME"));
            user.setLastName(resultSet.getString("USER_LNAME"));
            return user;
        }
    }

}
