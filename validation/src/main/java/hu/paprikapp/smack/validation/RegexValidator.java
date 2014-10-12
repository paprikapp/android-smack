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

import android.support.annotation.NonNull;

import java.util.regex.Pattern;

/**
 * @author Balazs Varga
 */
public class RegexValidator extends SmackAbstractValidator {

    public String mPattern;

    public RegexValidator(String message, @NonNull String pattern) {
        super(message);
        mPattern = pattern;
    }

    public String getPattern() {
        return mPattern;
    }

    public void setPattern(@NonNull String pattern) {
        mPattern = pattern;
    }

    @Override
    public boolean validate(String text) {
        Pattern exp = Pattern.compile(mPattern);

        if (exp.matcher(text).matches()) {
            return true;
        }
        return false;
    }
}
