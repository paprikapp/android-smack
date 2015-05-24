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
package hu.paprikapp.smack.validation.inputs;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * @author Balazs Varga
 */
public class EditTextValidator extends SmackAbstractInputValidator implements TextWatcher {

    private EditText mEditText;

    public EditTextValidator(@NonNull EditText editText) {
        mEditText = editText;
    }

    ///
    /// TextWatcher interface methods
    ///

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        validate();
    }

    ///
    /// SmackInputValidator interface methods
    ///

    @Override
    public boolean validate() {
        return validate(String.valueOf(mEditText.getText()));
    }

    @Override
    public void showError(String message) {
        mEditText.setError(message);
    }

    @Override
    public void hideError() {
        mEditText.setError(null);
    }
}
