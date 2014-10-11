package hu.paprikapp.smack.login.model;

/**
 * Pure abstract user definition for authentication process.
 *
 * @author Balazs Varga
 */
public interface SmackUser {

    /**
     * Gets the identifier of user.
     * @return Return the unique identifier of user.
     */
    String getId();

    /**
     * Sets the identifier of user.
     * @param id Unique identifier of user.
     */
    void setId(String id);

    /**
     * Gets the username of user.
     * @return Unique username of user.
     */
    String getUsername();

    /**
     * Sets the username of user.
     * @param username Unique username of user.
     */
    void setUsername(String username);

    /**
     * Sets the password for authentication process.
     * @param password Clear text password.
     */
    void setPassword(String password);
}
