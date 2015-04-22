package hu.paprikapp.smack.soup.app.login.strategy;

import android.content.Intent;
import android.support.v4.app.Fragment;

import hu.paprikapp.smack.soup.app.login.SmackUser;

/**
 * @author Balazs Varga
 */
public interface LoginStrategy {

    public static interface LoginStrategyCallback {
        void done(SmackUser user, Exception e);
    }

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void login(Fragment fragment, SmackUser user, LoginStrategyCallback callback);
}
