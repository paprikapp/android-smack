package hu.paprikapp.smack.soup.app.login;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * @author Balazs Varga
 */
interface LoginDispatcher {
    void dispatch(@NonNull Fragment fragment, SmackUser user);
}
