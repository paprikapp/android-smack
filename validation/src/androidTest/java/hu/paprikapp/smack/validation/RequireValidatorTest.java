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
public class RequireValidatorTest extends InstrumentationTestCase {

    private static final String REQUIRED_ERROR_MESSAGE = "This is required!";
    private RequireValidator mValidator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mValidator = new RequireValidator(REQUIRED_ERROR_MESSAGE);
    }

    public void testInvalid() {
        assertFalse(mValidator.validate(null));
        assertFalse(mValidator.validate(""));
        assertFalse(mValidator.validate("    "));
    }

    public void testValid() {
        assertTrue(mValidator.validate("Some text"));
        assertTrue(mValidator.validate(" a "));
    }
}
