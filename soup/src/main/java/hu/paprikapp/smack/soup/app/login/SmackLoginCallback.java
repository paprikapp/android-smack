package hu.paprikapp.smack.soup.app.login;

/**
 * @author Balazs Varga
 */
public interface SmackLoginCallback {
    void loginSuccess(SmackUser user);
    void loginFailed(Exception error);
}
