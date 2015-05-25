package hu.paprikapp.smack.soup.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import hu.paprikapp.smack.soup.R;
import hu.paprikapp.smack.soup.app.config.FragmentActivityConfig;
import hu.paprikapp.smack.soup.app.tools.FragmentBuilder;

/**
 * @author Balazs Varga
 */
public class SmackFragmentActivity extends SmackActivity {

    private static final String TAG_FRAGMENT = "TAG_FRAGMENT";

    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragment = getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT);

        if (mFragment == null && (mScreenConfig instanceof FragmentActivityConfig)) {
            FragmentActivityConfig config = (FragmentActivityConfig) mScreenConfig;

            // TODO remove hardcoded login fragment.
            mFragment = FragmentBuilder.newFragment(this, config.getFragmentClass())
                    .withFragmentConfig(config.getFragmentConfig())
                    .create();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.smack_fragment_container, mFragment, TAG_FRAGMENT)
                    .commit();
        }
    }

    @Override
    public void startLoading() {
        if (mFragment != null && mFragment instanceof SmackFragment) {
            ((SmackFragment) mFragment).startLoading();
        } else {
            super.startLoading();
        }
    }

    @Override
    public void stopLoading() {
        if (mFragment != null && mFragment instanceof SmackFragment) {
            ((SmackFragment) mFragment).stopLoading();
        } else {
            super.stopLoading();
        }
    }
}
