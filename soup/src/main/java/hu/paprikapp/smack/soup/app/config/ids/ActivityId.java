package hu.paprikapp.smack.soup.app.config.ids;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * @author Balazs Varga
 */
public class ActivityId implements ScreenId {
    private String mValue;

    public ActivityId(@NonNull final String value) {
        mValue = value;
    }

    @Override
    public String value() {
        return mValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ActivityId) {
            return TextUtils.equals(((ActivityId) o).mValue, mValue);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return mValue.hashCode();
    }
}
