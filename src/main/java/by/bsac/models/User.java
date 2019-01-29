package by.bsac.models;

import java.io.Serializable;

/**
 * User model.
 */
public class User implements Serializable {

    /* Class global variables */
    private Integer userId; //User ID (creating by database autoincrement).
    private String firstName; // User first name.
    private String lastName; // user last name.
    private String userEmail; // User email address.
    private String userPassword; //User password.

    /* Class methods
     * getters and setters
    */
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
