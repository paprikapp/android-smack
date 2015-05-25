package hu.paprikapp.smack.soup.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hu.paprikapp.smack.soup.R;
import hu.paprikapp.smack.soup.app.config.ScreenConfig;
import hu.paprikapp.smack.soup.util.EasyBundle;
import hu.paprikapp.smack.soup.widget.ProgressView;

/**
 * @author Balazs Varga
 */
public class SmackActivity extends AppCompatActivity {

    private ProgressView mProgressView;

    protected ScreenConfig mScreenConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScreenConfig = EasyBundle.getParcelable(Args.SCREEN_CONFIG, savedInstanceState, getIntent().getExtras());

        if (mScreenConfig != null && mScreenConfig.getLayoutRes() != Args.INVALID_LAYOUT_RES) {

            if (mScreenConfig.getProgressLayoutRes() != Args.INVALID_LAYOUT_RES) {
                setContentView(R.layout.activity_default_content_view);
                mProgressView = (ProgressView) findViewById(R.id.smack_progress_view);
                mProgressView.setContentView(mScreenConfig.getLayoutRes());
                mProgressView.setProgressView(mScreenConfig.getProgressLayoutRes());
            } else {
                setContentView(mScreenConfig.getLayoutRes());
            }
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Args.SCREEN_CONFIG, mScreenConfig);
    }

    public synchronized void startLoading() {
        if (mProgressView != null) {
            mProgressView.startProgress();
        }
    }

    public synchronized void stopLoading() {
        if (mProgressView != null) {
            mProgressView.stopProgress();
        }
    }
}
