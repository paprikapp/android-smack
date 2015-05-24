package hu.paprikapp.smack.soup.app.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;

import hu.paprikapp.smack.soup.app.Args;

/**
 * @author Balazs Varga
 */
public class IntentBuilder<T extends Activity> {

    private Intent mIntent;

    private IntentBuilder(Context context, Class<T> clazz) {
        mIntent = new Intent(context, clazz);
    }

    public static <T extends Activity> IntentBuilder<T> newActivity(Context context, Class<T> clazz) {
        return new IntentBuilder<>(context, clazz);
    }

    public IntentBuilder<T> withLayout(@LayoutRes int layoutRes) {
        mIntent.putExtra(Args.LAYOUT_ID, layoutRes);
        return this;
    }

    public IntentBuilder<T> withProgressLayout(@LayoutRes int progressLayout) {
        mIntent.putExtra(Args.PROGRESS_LAYOUT_ID, progressLayout);
        return this;
    }

    public Intent create() {
        Intent intent = mIntent;
        destroy();
        return intent;
    }

    private void destroy() {
        mIntent = null;
    }
}
