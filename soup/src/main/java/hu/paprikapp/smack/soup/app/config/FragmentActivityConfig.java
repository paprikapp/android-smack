package hu.paprikapp.smack.soup.app.config;

import android.os.Parcel;
import android.support.v4.app.Fragment;

/**
 * @author Balazs Varga
 */
public class FragmentActivityConfig extends ActivityConfig {

    private Class<? extends Fragment> mFragmentClass;
    private FragmentConfig mFragmentConfig;

    public FragmentActivityConfig() {
    }

    protected FragmentActivityConfig(Parcel in) {
        super(in);
        mFragmentClass = (Class<Fragment>) in.readSerializable();
        mFragmentConfig = in.readParcelable(FragmentConfig.class.getClassLoader());
    }

    public Class<? extends Fragment> getFragmentClass() {
        return mFragmentClass;
    }

    public void setFragmentClass(Class<? extends Fragment> fragmentClass) {
        mFragmentClass = fragmentClass;
    }

    public FragmentConfig getFragmentConfig() {
        return mFragmentConfig;
    }

    public void setFragmentConfig(FragmentConfig fragmentConfig) {
        mFragmentConfig = fragmentConfig;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeSerializable(mFragmentClass);
        dest.writeParcelable(mFragmentConfig, flags);
    }

    public static final Creator<FragmentActivityConfig> CREATOR = new Creator<FragmentActivityConfig>() {
        @Override
        public FragmentActivityConfig createFromParcel(Parcel source) {
            return new FragmentActivityConfig(source);
        }

        @Override
        public FragmentActivityConfig[] newArray(int size) {
            return new FragmentActivityConfig[size];
        }
    };
}
