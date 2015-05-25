package hu.paprikapp.smack.soup.app.config;

import android.os.Parcel;

import hu.paprikapp.smack.soup.app.config.ids.FragmentId;
import hu.paprikapp.smack.soup.util.EasyParcelable;

/**
 * @author Balazs Varga
 */
public class FragmentConfig extends AbstractScreenConfig<FragmentId> {

    public FragmentConfig() {
    }

    protected FragmentConfig(Parcel in) {
        super(in);
    }

    public static final Creator<FragmentConfig> CREATOR = EasyParcelable.createCreator(FragmentConfig.class);
}
