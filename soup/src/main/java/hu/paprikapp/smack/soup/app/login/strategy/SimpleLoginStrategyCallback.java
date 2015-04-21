package hu.paprikapp.smack.soup.app.login.strategy;

import hu.paprikapp.smack.soup.app.login.SmackLoginCallback;
import hu.paprikapp.smack.soup.app.login.SmackUser;

/**
 * @author Balazs Varga
 */
public class SimpleLoginStrategyCallback implements LoginStrategy.LoginStrategyCallback {

    private SmackLoginCallback loginCallback;

    public SimpleLoginStrategyCallback(SmackLoginCallback loginCallback) {
        this.loginCallback = loginCallback;
    }

    @Override
    public void success(SmackUser user, Exception e) {
        if (loginCallback != null) {
            if (e == null) {
                loginCallback.loginSuccess(user);
            } else {
                loginCallback.loginFailed(e);
            }
        }
    }
}
