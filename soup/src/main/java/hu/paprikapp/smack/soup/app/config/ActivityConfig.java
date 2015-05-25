package hu.paprikapp.smack.soup.app.config;

import android.os.Parcel;

import hu.paprikapp.smack.soup.app.config.ids.ActivityId;
import hu.paprikapp.smack.soup.util.EasyParcelable;

/**
 * @author Balazs Varga
 */
public class ActivityConfig extends AbstractScreenConfig<ActivityId> {

    public ActivityConfig() {
    }

    protected ActivityConfig(Parcel in) {
        super(in);
    }

    public static final Creator<ActivityConfig> CREATOR = EasyParcelable.createCreator(ActivityConfig.class);
}
