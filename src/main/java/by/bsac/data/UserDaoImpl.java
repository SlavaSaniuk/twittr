package by.bsac.data;

import by.bsac.models.User;
import by.bsac.data.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Class implements User DAO interface.
 *  This is service which have a logic of CRUD operations on user object in database.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDAO {

    /* Class global variables */
    private NamedParameterJdbcTemplate je; //JDBC Template (DAO engine).

    /* Class constructors */
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

        //SQL statement syntax:
        String sql = "SELECT * FROM USER WHERE USER_ID = :id LIMIT 0,1;";

        //Map of named parameters to SQL statement:
        Map<String, Object> named_parameters = new HashMap<>();
        named_parameters.put("id", a_id);

        //Return User object:
        return this.je.queryForObject(sql, named_parameters, new UsersRowMapper() );

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

        //SQL statement syntax:
        String sql = "SELECT USER_ID, USER_EMAIL, USER_PASSWORD, USER_FNAME, USER_LNAME FROM USER WHERE USER_EMAIL = :email;";

        //Map of named parameters to SQL statement:
        Map<String, Object> named_parameters = new HashMap<>();
        named_parameters.put("email", a_email);

        //Return User object:
        return this.je.queryForObject(sql, named_parameters, new UsersRowMapper() );

    }

    @Override
    public void create(User a_user) {

        //SQL statement syntax:
        String sql = "INSERT INTO USER(USER_EMAIL, USER_PASSWORD, USER_FNAME, USER_LNAME) " +
                "VALUES(:email, :password, :fname, :lname);";

        //Map of named parameters to SQL statement:
        Map<String, Object> named_parameters = new HashMap<>();
        named_parameters.put("email", a_user.getUserEmail());
        named_parameters.put("password", a_user.getUserPassword());
        named_parameters.put("fname", a_user.getFirstName());
        named_parameters.put("lname", a_user.getLastName());

        //Execute update (INSERT);
        this.je.update(sql, named_parameters);

    }

    @Override
    public void update(User a_user) {

        //SQL statement syntax:
        String sql = " UPDATE USER SET USER_EMAIL = ':email', USER_PASSWORD = ':password', USER_FNAME = ':fname', USER_LNAME = ':lname' WHERE USER_ID = :id LIMIT 1;";

        //Map of named parameters to SQL statement:
        Map<String, Object> named_parameters = new HashMap<>();
        named_parameters.put("email", a_user.getUserEmail());
        named_parameters.put("password", a_user.getUserPassword());
        named_parameters.put("fname", a_user.getFirstName());
        named_parameters.put("lname", a_user.getLastName());
        named_parameters.put("id", a_user.getUserId());

        //Execute update (UPDATE);
        this.je.update(sql, named_parameters);
    }

    @Override
    public void delete(User a_user) {

        //SQL statement syntax:
        String sql = "DELETE FROM USER WHERE USER_ID = :id;";

        //Map of named parameters to SQL statement:
        Map<String, Object> named_parameters = new HashMap<>();
        named_parameters.put("id", a_user.getUserId());

        //EXECUTE update (DELETE);
        this.je.update(sql, named_parameters);
    }

    //Users row mapper.
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
