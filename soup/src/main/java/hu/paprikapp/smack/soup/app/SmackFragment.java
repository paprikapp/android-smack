package hu.paprikapp.smack.soup.app;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.paprikapp.smack.soup.util.EasyBundle;
import hu.paprikapp.smack.soup.util.dialog.SmackDialog;

/**
 * @author Balazs Varga
 */
public class SmackFragment extends Fragment {

    @LayoutRes
    private int mLayoutRes;
    @LayoutRes
    private int mProgressLayoutRes;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLayoutRes = EasyBundle.getInt(Args.LAYOUT_ID, Args.INVALID_LAYOUT_ID, savedInstanceState, getArguments());
        mProgressLayoutRes = EasyBundle.getInt(Args.PROGRESS_LAYOUT_ID, Args.INVALID_LAYOUT_ID, savedInstanceState, getArguments());

        if (mLayoutRes != Args.INVALID_LAYOUT_ID) {
            return inflater.inflate(mLayoutRes, container, false);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Args.LAYOUT_ID, mLayoutRes);
        outState.putInt(Args.PROGRESS_LAYOUT_ID, mProgressLayoutRes);
    }

    public void startLoading() {
        if (mProgressLayoutRes != Args.INVALID_LAYOUT_ID) {

        }
    }

    public void stopLoading() {
        // TODO need implement this
    }
}
