package hu.paprikapp.smack.soup.util;

import android.os.Bundle;

/**
 * @author Balazs Varga
 */
public class EasyBundle {
    private EasyBundle() {
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
}
