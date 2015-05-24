/*
 * Copyright (C) 2014 Paprikapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hu.paprikapp.smack.soup.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * @author Balázs Varga
 */
public abstract class SmackSplashActivity extends Activity {

    private static final double DEFAULT_SPLASH_DELAY_MS = 2.5 * 1000;

    protected int mMinDisplayMs = (int) DEFAULT_SPLASH_DELAY_MS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final long start = System.currentTimeMillis();

        new Thread(new Runnable() {
            public void run() {

                doStuffInBackground(getApplication());

                // Make sure we display splash for MIN_DISPLAY_MS
                final long duration = System.currentTimeMillis() - start;
                if (duration < mMinDisplayMs) {
                    try {
                        Thread.sleep(mMinDisplayMs - duration);
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
    protected void doStuffInBackground(Application app)
    {
        // Hook
    }

    /**
     *
     */
    protected abstract void startNextActivity();
}
