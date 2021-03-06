package hu.paprikapp.smack.soup.util.dialog;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

/**
 * @author Balazs Varga
 */
public class SmackDialog {

    private static final String TAG_DIALOG = "TAG_DIALOG";

    private SmackDialog() {
        throw new UnsupportedOperationException("No instances.");
    }

    public static void showNeedInternetDialog(@NonNull final Activity activity) {
        DialogUtil.createNeedInternetDialog(activity).show();
    }

    public static void showNeedInternetDialogFragment(@NonNull final FragmentManager fragmentManager) {
        DialogFragment dialog = NeedInternetDialogFragment.newInstance();
        dialog.show(fragmentManager, TAG_DIALOG);
    }
}
