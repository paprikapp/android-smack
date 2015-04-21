package hu.paprikapp.smack.soup.util.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * @author Balazs Varga
 */
public class NeedInternetDialogFragment extends DialogFragment {

    public static NeedInternetDialogFragment newInstance() {
        NeedInternetDialogFragment fragment = new NeedInternetDialogFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return DialogUtil.createNeedInternetDialog(getActivity());
    }
}
