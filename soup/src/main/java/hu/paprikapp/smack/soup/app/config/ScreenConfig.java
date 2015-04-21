package hu.paprikapp.smack.soup.app.config;

import android.support.annotation.LayoutRes;

/**
 * @author Balazs Varga
 */
public interface ScreenConfig<T extends ScreenId> {

    T getScreenId();

    @LayoutRes
    int getLayoutId();
}
