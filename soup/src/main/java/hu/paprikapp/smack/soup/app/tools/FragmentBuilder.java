package hu.paprikapp.smack.soup.app.tools;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import hu.paprikapp.smack.soup.app.Args;

/**
 * @author Balazs Varga
 */
public class FragmentBuilder<T extends Fragment> {

    private Context mContext;
    private Class<T> mFragmentClass;
    private int mLayoutRes;
    private int mProgressLayoutRes;

    private FragmentBuilder(@NonNull Context context, @NonNull Class<T> fragmentClass) {
        mContext = context;
        mFragmentClass = fragmentClass;
    }

    public static <T extends Fragment> FragmentBuilder<T> newFragment(@NonNull Context context, @NonNull Class<T> fragmentClass) {
        return new FragmentBuilder<T>(context, fragmentClass);
    }

    public FragmentBuilder<T> withLayout(@LayoutRes final int layoutRes) {
        mLayoutRes = layoutRes;
        return this;
    }

    public FragmentBuilder<T> withProgressLayout(@LayoutRes final int progressLayoutRes) {
        mProgressLayoutRes = progressLayoutRes;
        return this;
    }

    @SuppressWarnings("unchecked")
    public T create() {
        Bundle args = new Bundle();
        args.putInt(Args.LAYOUT_ID, mLayoutRes);
        args.putInt(Args.PROGRESS_LAYOUT_ID, mProgressLayoutRes);
        T instance = (T) Fragment.instantiate(mContext, mFragmentClass.getName(), args);
        destroy();
        return instance;
    }

    private void destroy() {
        mContext = null;
        mFragmentClass = null;
        mLayoutRes = 0;
        mProgressLayoutRes = 0;
    }
}
