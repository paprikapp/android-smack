package hu.paprikapp.smack.soup.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import hu.paprikapp.smack.soup.util.EasyBundle;

/**
 * @author Balazs Varga
 */
public class SmackActivity extends AppCompatActivity {

    public static <T extends SmackActivity> Intent makeIntent(@NonNull Context context, @LayoutRes int layoutId, @NonNull Class<T> activityClass) {
        Intent intent = new Intent(context, activityClass);
        intent.putExtra(Args.LAYOUT_ID, layoutId);
        return intent;
    }

    @LayoutRes
    protected int layoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutId = EasyBundle.getInt(Args.LAYOUT_ID, Args.INVALID_LAYOUT_ID, savedInstanceState, getIntent().getExtras());
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(Args.LAYOUT_ID, layoutId);
    }

    public void startLoading() {
        // TODO need implement this
    }

    public void stopLoading() {
        // TODO need implement this
    }
}
