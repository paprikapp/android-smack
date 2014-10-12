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
package hu.paprikapp.smack.validation.listener;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import hu.paprikapp.smack.validation.inputs.SmackValidationForm;

/**
 * @author Balazs Varga
 */
public class OnClickListenerValidationWrapper implements View.OnClickListener {

    private SmackValidationForm mValidationForm;
    private View.OnClickListener mOnClickListener;

    public OnClickListenerValidationWrapper(@NonNull SmackValidationForm validationForm, @Nullable View.OnClickListener listener) {
        mValidationForm = validationForm;
        mOnClickListener = listener;
    }

    @Override
    public void onClick(View v) {

        if (!mValidationForm.validate())
            return;

        if (mOnClickListener != null) {
            mOnClickListener.onClick(v);
        }
    }
}
