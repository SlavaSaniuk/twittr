package by.bsac.models;

/**
 * User model.
 * Factory for all users objects.
 */
public class User {

    /* Class global variables */

    // User identifier (Integer type, Max 8 digit);
    private int user_id;

    // User email address (String type, Max 30 chars);
    private String user_email;

    // User password (String type, Max 30 chars);
    private String user_pass;

    /* Class constructors */
    // Default constructor

    /* Class methods */
    // Getters and setters

    public int getUserId() {
        return this.user_id;
    }

    public String getUserEmail() {
        return this.user_email;
    }

    public String getUserPassword() {
        return this.user_pass;
    }

    public void setUserId(int a_id) {
        this.user_id = a_id;
    }

    public void setUserEmail(String a_email) {
        this.user_email = a_email;
    }

    public void setUserPassword(String a_pass) {
        this.user_pass = a_pass;
    }



}
