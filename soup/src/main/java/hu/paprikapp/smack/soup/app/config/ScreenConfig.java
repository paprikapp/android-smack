package hu.paprikapp.smack.soup.app.config;

import android.os.Parcelable;
import android.support.annotation.LayoutRes;

import hu.paprikapp.smack.soup.app.config.ids.ScreenId;

/**
 * @author Balazs Varga
 */
public interface ScreenConfig<T extends ScreenId> extends Parcelable {

    T getScreenId();

    @LayoutRes
    int getLayoutRes();

    @LayoutRes
    int getProgressLayoutRes();
}
