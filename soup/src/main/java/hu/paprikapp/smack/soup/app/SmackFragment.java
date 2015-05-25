package hu.paprikapp.smack.soup.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.paprikapp.smack.soup.app.config.Args;
import hu.paprikapp.smack.soup.app.config.ScreenConfig;
import hu.paprikapp.smack.soup.util.EasyBundle;
import hu.paprikapp.smack.soup.widget.ProgressView;

/**
 * @author Balazs Varga
 */
public class SmackFragment extends Fragment {

    private ProgressView mProgressView;

    protected ScreenConfig mScreenConfig;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mScreenConfig = EasyBundle.getParcelable(Args.SCREEN_CONFIG, savedInstanceState, getArguments());

        if (mScreenConfig != null && mScreenConfig.getLayoutRes() != Args.INVALID_LAYOUT_RES) {
            if (mScreenConfig.getProgressLayoutRes() != Args.INVALID_LAYOUT_RES) {
                mProgressView = ProgressView.initAndGetContentView(getActivity(), mScreenConfig.getLayoutRes(), mScreenConfig.getProgressLayoutRes());
                return mProgressView;
            }

            return inflater.inflate(mScreenConfig.getLayoutRes(), container, false);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Args.SCREEN_CONFIG, mScreenConfig);
    }

    public synchronized void startLoading() {
        if (isAdded() && !isDetached()) {
            if (mProgressView != null) {
                mProgressView.startProgress();
            }
        }
    }

    public synchronized void stopLoading() {
        if (isAdded() && !isDetached()) {
            if (mProgressView != null) {
                mProgressView.stopProgress();
            }
        }
    }
}
