package hu.paprikapp.smack.soup.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import hu.paprikapp.smack.soup.R;
import hu.paprikapp.smack.soup.app.login.SmackLoginFragment;

/**
 * @author Balazs Varga
 */
public class SmackFragmentActivity extends SmackActivity {

    private static final String TAG_FRAGMENT = "TAG_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO bad logic. layoutId has activity, not the fragment.
        setContentView(R.layout.activity_smack_fragment);

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT);

        if (fragment == null) {
            fragment = SmackLoginFragment.newInstance(this, layoutId);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.smack_fragment_container, fragment, TAG_FRAGMENT)
                    .commit();
        }
    }
}
