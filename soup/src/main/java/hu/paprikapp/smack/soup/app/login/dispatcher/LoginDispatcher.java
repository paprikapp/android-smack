package hu.paprikapp.smack.soup.app.login.dispatcher;

import android.support.v4.app.Fragment;

import hu.paprikapp.smack.soup.app.login.SmackUser;

/**
 * @author Balazs Varga
 */
public interface LoginDispatcher {
    void dispatch(Fragment fragment, SmackUser user);
}
