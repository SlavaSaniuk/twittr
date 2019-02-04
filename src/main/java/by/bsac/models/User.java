package by.bsac.models;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

/**
 * User model.
 * Factory for all users objects.
 */
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode= ScopedProxyMode.TARGET_CLASS)
public class User {

    /* Class global variables */

    // User identifier (Integer type, Max 8 digit);
    private int user_id;

    // User email address (String type, Max 30 chars);
    private String userEmail;

    // User password (String type, Max 30 chars);
    private String userPassword;

    /* Class constructors */
    // Default constructor

    /* Class methods */
    // Getters and setters

    public int getUserId() {
        return this.user_id;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserId(int a_id) {
        this.user_id = a_id;
    }

    public void setUserEmail(String a_email) {
        this.userEmail = a_email;
    }

    public void setUserPassword(String a_pass) {
        this.userPassword = a_pass;
    }

    @Override
    public String toString() {
        return this.getUserId() + ": " +getUserEmail();
    }
}
