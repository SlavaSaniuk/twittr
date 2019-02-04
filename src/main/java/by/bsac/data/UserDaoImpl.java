package by.bsac.data;

import by.bsac.data.dao.UserDao;
import by.bsac.models.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class UserDaoImpl implements UserDao {


    /* Class global variables */

    //NamedParameterJdbcTemplate user as SQL query provider.
    private NamedParameterJdbcTemplate jt;

    /* Class constructors */

    /**
     * Create common UserDao bean.
     * @param a_ds - DataSource object (Depending on the active profile).
     */
    public UserDaoImpl(DataSource a_ds) {

        //Initialize NamedParameterJdbcTemplate field.
        this.jt = new NamedParameterJdbcTemplate(a_ds);
    }

    /* Class methods */

    @Override
    public User findById(int a_id) {
        return null;
    }

    @Override
    public User findByEmail(String a_email) {

        //SQL statement syntax:
        String sql ="SELECT * FROM user WHERE user_email = :email";

        //Set named parameters:
        Map<String, String> named_parameters = new HashMap<>();
        named_parameters.put("email", a_email);

        //Execute query (SELECT):
        List<User> users = this.jt.query(sql, named_parameters, new UserRowMapper());

        if (users.isEmpty()) return null;
        else return users.get(0);

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void create(User user) {

        //SQL statement syntax:
        String sql = "INSERT INTO user (user_email, user_password) VALUES (:email, :pass);";

        //Set named parameters
        Map<String, String> named_parameters = new HashMap<>();
        named_parameters.put("email", user.getUserEmail());
        named_parameters.put("pass", user.getUserPassword());

        //Execute update (INSERT):
        this.jt.update(sql, named_parameters);

        System.out.println(user.toString() + " - SUCCESSFULLY CREATED IN DATABASE.");

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {

            User user = new User();

            user.setUserId(resultSet.getInt("user_id"));
            user.setUserEmail(resultSet.getString("user_email"));
            user.setUserPassword(resultSet.getString("user_password"));

            return user;
        }
    }

}
