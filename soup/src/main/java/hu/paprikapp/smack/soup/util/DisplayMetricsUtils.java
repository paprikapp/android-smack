package hu.paprikapp.smack.soup.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * Created by warnyul on 9/22/2014.
 */
public final class DisplayMetricsUtils {

    private static DisplayMetrics mDisplayMetrics;

    private DisplayMetricsUtils() {}

    public static void init(@NonNull Context context) {
        mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    public static float density() {
        return mDisplayMetrics.density;
    }

    public static float densityDpi() {
        return mDisplayMetrics.densityDpi;
    }

    public static float scaledDensity() {
        return mDisplayMetrics.scaledDensity;
    }

    public static float xdpi() {
        return mDisplayMetrics.xdpi;
    }

    public static float ydpi() {
        return mDisplayMetrics.ydpi;
    }

    public static int widthPixels() {
        return mDisplayMetrics.widthPixels;
    }

    public static int heightPixels() {
        return mDisplayMetrics.heightPixels;
    }

}
