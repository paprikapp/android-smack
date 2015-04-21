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
package hu.paprikapp.smack.soup.app.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import hu.paprikapp.smack.soup.R;
import hu.paprikapp.smack.soup.app.SmackFragmentActivity;

/**
 * @author Balazs Varga
 */
public class SmackLoginActivity extends SmackFragmentActivity implements SmackLoginCallback {

    @Override
    public void loginSuccess(SmackUser user) {
        // Hook method.
    }

    @Override
    public void loginFailed(Exception error) {
        // Hook method.
    }
}