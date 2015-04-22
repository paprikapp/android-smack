package hu.paprikapp.smack.soup.app.login.strategy;

import hu.paprikapp.smack.soup.app.login.SmackLoginCallback;
import hu.paprikapp.smack.soup.app.login.SmackUser;

/**
 * @author Balazs Varga
 */
public class SimpleLoginStrategyCallback implements LoginStrategy.LoginStrategyCallback {

    private final SmackLoginCallback loginCallback;

    public SimpleLoginStrategyCallback(SmackLoginCallback loginCallback) {
        this.loginCallback = loginCallback;
    }

    @Override
    public void done(SmackUser user, Exception e) {
        if (loginCallback != null) {
            if (e == null) {
                if (user == null) {
                    loginCallback.canceled();
                } else {
                    loginCallback.success(user);
                }
            } else {
                loginCallback.failed(e);
            }
        }
    }
}
