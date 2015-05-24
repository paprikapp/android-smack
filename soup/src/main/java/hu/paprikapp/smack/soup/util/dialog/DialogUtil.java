package hu.paprikapp.smack.soup.util.dialog;

import android.app.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import hu.paprikapp.smack.soup.R;

/**
 * @author Balazs Varga
 */
class DialogUtil {
    private DialogUtil() {
        throw new UnsupportedOperationException("No instances.");
    }

    public static Dialog createNeedInternetDialog(@NonNull final Activity activity) {
        return new AlertDialog.Builder(activity)
                .setMessage(R.string.need_internet_connection_dialog_title)
                .setNegativeButton(R.string.need_internet_connection_dialog_negative_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setPositiveButton(R.string.need_internet_connection_dialog_settings_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.startActivity(new Intent(Settings.ACTION_SETTINGS));
                    }
                }).create();
    }
}
