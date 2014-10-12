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
package hu.paprikapp.smack.validation;

import android.text.TextUtils;

/**
 * @author Balázs Varga
 */
public class RequireValidator extends SmackAbstractValidator {

    public RequireValidator(String message) {
        super(message);
    }

    @Override
    public boolean validate(String text) {
        if (TextUtils.isEmpty(text) || TextUtils.getTrimmedLength(text) == 0) {
            return false;
        }
        return true;
    }
}
