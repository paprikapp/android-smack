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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Balazs Varga
 */
public class SmackValidationForm  {

    public static enum ValidationType {
        StopOnFirstError,
        ValidateAll
    }

    private final List<SmackInputValidator> mValidators = new ArrayList<SmackInputValidator>();

    private final ValidationType mValidationType;

    public SmackValidationForm(ValidationType validationType) {
        mValidationType = validationType;
    }

    /**
     * The default validation type is: ValidateAll.
     */
    public SmackValidationForm() {
        this(ValidationType.ValidateAll);
    }

    public ValidationType getValidationType() {
        return mValidationType;
    }

    public void addValidator(SmackInputValidator validator) {
        mValidators.add(validator);
    }

    public boolean validate() {
        // We are optimist
        boolean isValid = true;

        for (SmackInputValidator validator : mValidators) {
            if (!validator.validate()) {
                isValid = false;

                if (mValidationType == ValidationType.StopOnFirstError) {
                    return isValid;
                }
            }
        }

        return isValid;
    }
}
