package hu.paprikapp.smack.login;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * @author Balázs Varga
 */
public abstract class SmackSplashActivity extends Activity {

    private static final double DEFAULT_SPLASH_DELAY_MS = 2.5 * 1000;

    protected int minDisplayMs = (int) DEFAULT_SPLASH_DELAY_MS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final long start = System.currentTimeMillis();

        new Thread(new Runnable() {
            public void run() {

                doStuffInBackground(getApplication());

                // Make sure we display splash for MIN_DISPLAY_MS
                final long duration = System.currentTimeMillis() - start;
                if (duration < minDisplayMs) {
                    try {
                        Thread.sleep(minDisplayMs - duration);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                }

                startNextActivity();
                finish();
            }

        }).start();
    }

    /**
     *
     * @param app
     */
    protected abstract void doStuffInBackground(Application app);

    /**
     *
     */
    protected abstract void startNextActivity();
}
