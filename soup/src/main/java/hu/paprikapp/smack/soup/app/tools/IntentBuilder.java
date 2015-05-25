package hu.paprikapp.smack.soup.app.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import hu.paprikapp.smack.soup.app.config.Args;
import hu.paprikapp.smack.soup.app.config.AbstractScreenConfig;
import hu.paprikapp.smack.soup.app.config.ActivityConfig;
import hu.paprikapp.smack.soup.app.config.FragmentActivityConfig;
import hu.paprikapp.smack.soup.app.config.FragmentConfig;

/**
 * @author Balazs Varga
 */
public class IntentBuilder<T extends Activity> {

    public static <T extends Activity> IntentBuilder<T> newActivity(Context context, Class<T> clazz) {
        return new IntentBuilder<>(context, clazz);
    }

    private Intent mIntent;
    @LayoutRes
    private int mLayoutRes = Args.INVALID_LAYOUT_RES;
    @LayoutRes
    private int mProgressLayoutRes = Args.INVALID_LAYOUT_RES;
    private FragmentConfig mFragmentConfig;
    private Class<? extends Fragment> mFragmentClass;

    private IntentBuilder(Context context, Class<T> clazz) {
        mIntent = new Intent(context, clazz);
    }

    public IntentBuilder<T> withLayout(@LayoutRes int layoutRes) {
        mLayoutRes = layoutRes;
        return this;
    }

    public IntentBuilder<T> withProgressLayout(@LayoutRes int progressLayout) {
        mProgressLayoutRes = progressLayout;
        return this;
    }

    public IntentBuilder<T> withFragmentConfig(@NonNull FragmentConfig fragmentConfig, Class<? extends Fragment> fragmentClass) {
        mFragmentClass = fragmentClass;
        return withFragmentConfig(fragmentConfig);
    }

    public IntentBuilder<T> withFragmentConfig(@NonNull FragmentConfig fragmentConfig) {
        mFragmentConfig = fragmentConfig;
        return this;
    }

    private void destroy() {
        mIntent = null;
        mLayoutRes = mProgressLayoutRes = Args.INVALID_LAYOUT_RES;
    }

    public Intent create() {
        final AbstractScreenConfig config;

        if (mFragmentConfig == null && mFragmentClass == null) {
            config = new ActivityConfig();
        } else {
            FragmentActivityConfig fragmentActivityConfig = new FragmentActivityConfig();
            fragmentActivityConfig.setFragmentConfig(mFragmentConfig);
            fragmentActivityConfig.setFragmentClass(mFragmentClass);
            config = fragmentActivityConfig;
        }

        config.setLayoutRes(mLayoutRes);
        config.setProgressLayoutRes(mProgressLayoutRes);

        mIntent.putExtra(Args.SCREEN_CONFIG, config);
        Intent intent = mIntent;

        destroy();
        return intent;
    }

}
