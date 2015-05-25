package hu.paprikapp.smack.soup.app.tools;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import hu.paprikapp.smack.soup.app.Args;
import hu.paprikapp.smack.soup.app.config.FragmentConfig;

/**
 * @author Balazs Varga
 */
public class FragmentBuilder<T extends Fragment> {

    private Context mContext;
    private Class<T> mFragmentClass;
    private FragmentConfig mFragmentConfig;

    private FragmentBuilder(@NonNull Context context, @NonNull Class<T> fragmentClass) {
        clean();
        mContext = context;
        mFragmentClass = fragmentClass;
    }

    public static <T extends Fragment> FragmentBuilder<T> newFragment(@NonNull Context context, @NonNull Class<T> fragmentClass) {
        return new FragmentBuilder<T>(context, fragmentClass);
    }

    public FragmentBuilder<T> withLayout(@LayoutRes final int layoutRes) {
        mFragmentConfig.setLayoutRes(layoutRes);
        return this;
    }

    public FragmentBuilder<T> withProgressLayout(@LayoutRes final int progressLayoutRes) {
        mFragmentConfig.setProgressLayoutRes(progressLayoutRes);
        return this;
    }

    public FragmentBuilder<T> withFragmentConfig(@NonNull final FragmentConfig fragmentConfig) {
        mFragmentConfig = fragmentConfig;
        return this;
    }

    @SuppressWarnings("unchecked")
    public T create() {

        final Bundle args = new Bundle();
        args.putParcelable(Args.SCREEN_CONFIG, mFragmentConfig);
        T instance = (T) Fragment.instantiate(mContext, mFragmentClass.getName(), args);
        clean();
        return instance;
    }

    private void clean() {
        mContext = null;
        mFragmentClass = null;
        mFragmentConfig = new FragmentConfig();
    }
}
