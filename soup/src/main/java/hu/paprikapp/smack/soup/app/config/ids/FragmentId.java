package hu.paprikapp.smack.soup.app.config.ids;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * @author Balazs Varga
 */
public class FragmentId implements ScreenId {
    private String mValue;

    public FragmentId(@NonNull final String value) {
        mValue = value;
    }

    @Override
    public String value() {
        return mValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FragmentId) {
            return TextUtils.equals(((FragmentId) o).mValue, mValue);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return mValue.hashCode();
    }
}
