package hu.paprikapp.smack.soup.app.login;

/**
 * @author Balazs Varga
 */
public interface SmackLoginCallback {

    void start();

    void success(SmackUser user);

    void failed(Exception error);

    void canceled();
}
