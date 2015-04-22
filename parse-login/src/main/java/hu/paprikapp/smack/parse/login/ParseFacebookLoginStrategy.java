package hu.paprikapp.smack.parse.login;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

import java.util.Collection;
import java.util.Collections;

import hu.paprikapp.smack.soup.app.login.SmackUser;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategy;

/**
 * @author Balazs Varga
 */
public class ParseFacebookLoginStrategy implements LoginStrategy {

    @Override
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public final void login(Fragment fragment, SmackUser user, final LoginStrategyCallback callback) {
       ParseFacebookUtils.logInWithReadPermissionsInBackground(fragment, getPermissions(), new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                safeCall(callback, (SmackUser)parseUser, e);
            }
        });
    }

    private final void safeCall(LoginStrategyCallback callback, SmackUser user, Exception e) {
        if (callback != null) {
            callback.done(user, e);
        }
    }

    protected Collection<String> getPermissions() {
        return Collections.emptyList();
    }
}
