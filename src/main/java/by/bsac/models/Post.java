package by.bsac.models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *  A simple post class.
 */
public class Post {

    /** Class global variables */
    private Integer post_id; //Post ID (Autoincrement)
    private String post_text; //Post text (Created by user)
    private Integer post_author_id; //Author ID of post
    private LocalDate post_date; //Post creation date (Automatically initialization)
    private LocalTime post_time; //Post creation time
    public static Integer post_next_id = 1; //Next post ID

    /** Class constructors */
    public Post(String a_text, Integer a_post_author_id) {
        setPostID();
        setPostText(a_text);
        setPostAuthorID(a_post_author_id);
        setPostDate();
        setPostTime();
    }

    /** Class methods */
    //Getter and setters
    public Integer getPostID() {
        return post_id;
    }

    //Automatically set ID to post object.
    private void setPostID() {
        this.post_id = post_next_id;
        post_next_id++;
    }

    public String getPostText() {
        return post_text;
    }

    public void setPostText(String post_text) {
        this.post_text = post_text;
    }

    public Integer getPostAuthorID() {
        return post_author_id;
    }

    public void setPostAuthorID(Integer post_author_id) {
        this.post_author_id = post_author_id;
    }

    public LocalDate getPostDate() {
        return post_date;
    }

    private void setPostDate() {
        this.post_date = LocalDate.now();
    }

    public LocalTime getPostTime() {
        return post_time;
    }

    private void setPostTime() {
        this.post_time = LocalTime.now();
    }

    public static Integer getPostNextID() {
        return post_next_id;
    }

    public static void setPostNextID(Integer post_next_id) {
        Post.post_next_id = post_next_id;
    }

    @Override
    public String toString() {
        return this.post_date.toString() +" " +this.post_time.toString() +" " +this.post_author_id.toString() +" : " +this.post_text;
    }
}
