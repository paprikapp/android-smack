package hu.paprikapp.smack.soup.app.config;

import android.os.Parcel;
import android.support.annotation.LayoutRes;

import hu.paprikapp.smack.soup.app.Args;

/**
 * @author Balazs Varga
 */
public abstract class AbstractScreenConfig<T extends ScreenId> implements ScreenConfig<T> {

    private T mScreenId;
    @LayoutRes
    private int mLayoutRes = Args.INVALID_LAYOUT_RES;
    @LayoutRes
    private int mProgressLayoutRes = Args.INVALID_LAYOUT_RES;

    public AbstractScreenConfig() {
    }

    @Override
    public T getScreenId() {
        return mScreenId;
    }

    @Override
    public int getLayoutRes() {
        return mLayoutRes;
    }

    @Override
    public int getProgressLayoutRes() {
        return mProgressLayoutRes;
    }

    /// Self methods

    public void setScreenId(final T screenId) {
        mScreenId = screenId;
    }

    public void setLayoutRes(@LayoutRes final int layoutRes) {
        mLayoutRes = layoutRes;
    }

    public void setProgressLayoutRes(@LayoutRes final int progressLayoutRes) {
        mProgressLayoutRes = progressLayoutRes;
    }


    /// Parcelable methods

    protected AbstractScreenConfig(Parcel in) {
        mScreenId = (T) in.readSerializable();
        mLayoutRes = in.readInt();
        mProgressLayoutRes = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(mScreenId);
        dest.writeInt(mLayoutRes);
        dest.writeInt(mProgressLayoutRes);
    }


}
