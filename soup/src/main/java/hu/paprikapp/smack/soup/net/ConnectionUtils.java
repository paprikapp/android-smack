package hu.paprikapp.smack.soup.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

/**
 * Created by warnyul on 29/08/14.
 */
public final class ConnectionUtils {

    private static Context mContext;

    private ConnectionUtils() {
    }

    public static void init(@NonNull Context context) {
        mContext = context.getApplicationContext();
    }

    public static boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnected();
        return isConnected;
    }
}
