package hu.paprikapp.smack.soup.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

/**
 * Created by warnyul on 29/08/14.
 */
public final class Net {

    private static ConnectivityManager connectivityManager;

    private Net() {
    }

    public static void init(@NonNull Context context) {
        connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static boolean isNotConnected() {
        return !isConnected();
    }

    public static boolean isConnected() {
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnected();
        return isConnected;
    }
}
