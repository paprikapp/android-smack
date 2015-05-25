package hu.paprikapp.smack.soup.app.config;

import android.os.Parcel;

/**
 * @author Balazs Varga
 */
public class FragmentConfig extends AbstractScreenConfig<FragmentId> {

    public FragmentConfig() {
    }

    protected FragmentConfig(Parcel in) {
        super(in);
    }

    public static final Creator<FragmentConfig> CREATOR = new Creator<FragmentConfig>() {
        @Override
        public FragmentConfig createFromParcel(Parcel source) {
            return new FragmentConfig(source);
        }

        @Override
        public FragmentConfig[] newArray(int size) {
            return new FragmentConfig[size];
        }
    };
}
