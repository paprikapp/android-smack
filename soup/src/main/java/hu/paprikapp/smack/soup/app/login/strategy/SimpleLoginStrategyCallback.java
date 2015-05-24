package hu.paprikapp.smack.soup.app.login.strategy;

import android.support.annotation.Nullable;

import hu.paprikapp.smack.soup.app.login.SmackLoginCallback;
import hu.paprikapp.smack.soup.app.login.SmackUser;

/**
 * @author Balazs Varga
 */
public class SimpleLoginStrategyCallback implements LoginStrategy.LoginStrategyCallback {

    private final SmackLoginCallback mLoginCallback;

    public SimpleLoginStrategyCallback(@Nullable final SmackLoginCallback loginCallback) {
        mLoginCallback = loginCallback;
    }

    @Override
    public void done(SmackUser user, Exception e) {
        if (mLoginCallback != null) {
            if (e == null) {
                if (user == null) {
                    mLoginCallback.canceled();
                } else {
                    mLoginCallback.success(user);
                }
            } else {
                mLoginCallback.failed(e);
            }
        }
    }
}
