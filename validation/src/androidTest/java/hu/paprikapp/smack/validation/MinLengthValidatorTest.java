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

import android.test.InstrumentationTestCase;

/**
 * @author Balazs Varga
 */
public class MinLengthValidatorTest extends InstrumentationTestCase {

    private static final int MIN_VALUE = 4;
    private static final String ERROR_MESSAGE = "Value is not greater than " + MIN_VALUE;
    private MinLengthValidator mMinLengthValidator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mMinLengthValidator = new MinLengthValidator(ERROR_MESSAGE, MIN_VALUE);
    }

    public void testInvalid() {
        assertFalse(mMinLengthValidator.validate("a"));
        assertFalse(mMinLengthValidator.validate("ab"));
        assertFalse(mMinLengthValidator.validate("abc"));
    }

    public void testValid() {
        assertTrue(mMinLengthValidator.validate("abcd"));
        assertTrue(mMinLengthValidator.validate("abcde"));
        assertTrue(mMinLengthValidator.validate(" ab "));
    }
}
