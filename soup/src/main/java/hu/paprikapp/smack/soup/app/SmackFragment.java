package hu.paprikapp.smack.soup.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.paprikapp.smack.soup.util.EasyBundle;

/**
 * @author Balazs Varga
 */
public class SmackFragment extends Fragment {

    private int layoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutId = EasyBundle.getInt(Args.LAYOUT_ID, Args.INVALID_LAYOUT_ID, savedInstanceState, getArguments());
        if (layoutId != Args.INVALID_LAYOUT_ID) {
            return inflater.inflate(layoutId, container, false);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Args.LAYOUT_ID, layoutId);
    }

    public void startLoading() {
        // TODO need implement this
    }

    public void stopLoading() {
        // TODO need implement this
    }
}
