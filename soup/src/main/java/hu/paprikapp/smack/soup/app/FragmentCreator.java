package hu.paprikapp.smack.soup.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * @author Balazs Varga
 */
public class FragmentCreator {

    public static <T extends Fragment> T create(@NonNull Context context, @NonNull Class<T> fragmentClass, @LayoutRes int layoutId) {
        Bundle args = new Bundle();
        args.putInt(Args.LAYOUT_ID, layoutId);
        return (T) Fragment.instantiate(context, fragmentClass.getName(), args);
    }
}
