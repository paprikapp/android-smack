package hu.paprikapp.smack.soup.app.config;

import android.os.Parcel;
import android.support.annotation.LayoutRes;

import hu.paprikapp.smack.soup.app.Args;

/**
 * @author Balazs Varga
 */
public class ActivityConfig implements ScreenConfig<ActivityId> {

    private ActivityId mActivityId;
    @LayoutRes
    private int mLayoutRes = Args.INVALID_LAYOUT_ID;
    @LayoutRes
    private int mProgressLayoutRes = Args.INVALID_LAYOUT_ID;

    public ActivityConfig() {

    }

    /// ScreenConfig methods

    @Override
    public ActivityId getScreenId() {
        return mActivityId;
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

    public ActivityConfig setScreenId(final ActivityId activityId) {
        mActivityId = activityId;
        return this;
    }

    public ActivityConfig setLayoutRes(@LayoutRes final int layoutRes) {
        mLayoutRes = layoutRes;
        return this;
    }

    public ActivityConfig setProgressLayoutRes(@LayoutRes final int progressLayoutRes) {
        mProgressLayoutRes = progressLayoutRes;
        return this;
    }

    /// Parcelable methods

    protected ActivityConfig(Parcel in) {
        mActivityId = (ActivityId) in.readSerializable();
        mLayoutRes = in.readInt();
        mProgressLayoutRes = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(mActivityId);
        dest.writeInt(mLayoutRes);
        dest.writeInt(mProgressLayoutRes);
    }

    public static final Creator<ActivityConfig> CREATOR = new Creator<ActivityConfig>() {
        @Override
        public ActivityConfig createFromParcel(Parcel source) {
            return new ActivityConfig(source);
        }

        @Override
        public ActivityConfig[] newArray(int size) {
            return new ActivityConfig[size];
        }
    };
}
