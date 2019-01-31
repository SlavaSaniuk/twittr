package by.bsac.data.dao;

import by.bsac.models.Post;

/**
 *  DAO interface to execute CRUD operations on "Post" data.
 */
public interface PostsDAO {

    /** Interface methods */
    Post[] findAll();
    Post findByID(Integer PostID);
    void create();
    void update();
    void delete();


}
