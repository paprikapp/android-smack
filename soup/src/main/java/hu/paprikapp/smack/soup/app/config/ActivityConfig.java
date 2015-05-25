package hu.paprikapp.smack.soup.app.config;

import android.os.Parcel;

/**
 * @author Balazs Varga
 */
public class ActivityConfig extends AbstractScreenConfig<ActivityId> {

    public ActivityConfig() {
    }

    protected ActivityConfig(Parcel in) {
        super(in);
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
