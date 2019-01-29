package by.bsac.services;

import by.bsac.models.Post;
import by.bsac.services.dao.PostsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 *
 */
@Component()
public class PostsDaoImpl implements PostsDAO {


    /* Class global variables */
    private JdbcTemplate jdbc_template;
    private String post_text = "POST_TEXT";

    /* Class constructors */
    @Autowired
    public PostsDaoImpl(DataSource data_source) {
        this.jdbc_template = new JdbcTemplate(data_source);
    }

   /** Class methods */
    @Override
    public Post[] findAll() {
        return new Post[0];
    }

    @Override
    public Post findByID(Integer PostID) {
        return null;
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    public String getTextOfPost(Integer PostID) {
        return jdbc_template.queryForObject("SELECT POST_TEXT FROM POST WHERE POST_ID = ?", new Object[] {PostID}, String.class);
    }
}
