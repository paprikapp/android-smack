package hu.paprikapp.smack.soup.util;

import android.os.Bundle;
import android.os.Parcelable;

/**
 * @author Balazs Varga
 */
public class EasyBundle {
    private EasyBundle() {
        throw new UnsupportedOperationException("No instances.");
    }

    public static int getInt(String key, Bundle... args) {
        return getInt(key, 0, args);
    }

    public static int getInt(String key, int defaultValue, Bundle... args) {
        int value = defaultValue;

        for (Bundle bundle : args) {
            if (bundle != null) {
                value = bundle.getInt(key, defaultValue);
            }
        }
        return value;
    }

    public static <T extends Parcelable> T getParcelable(String key, Bundle... args) {
        T value = null;

        for (Bundle bundle : args) {
            if (bundle != null) {
                value = bundle.getParcelable(key);
            }
        }
        return value;
    }
}
