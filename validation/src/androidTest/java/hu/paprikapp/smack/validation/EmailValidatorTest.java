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
public class EmailValidatorTest extends InstrumentationTestCase {

    private static final String ERROR_MESSAGE = "Email is invalid!";

    private EmailValidator mEmailValidator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mEmailValidator = new EmailValidator(ERROR_MESSAGE);
    }

    public void testInvalid() {
        assertFalse(mEmailValidator.validate(""));
        assertFalse(mEmailValidator.validate("Some text"));
        assertFalse(mEmailValidator.validate("google.com"));
        assertFalse(mEmailValidator.validate("http://google.com"));
        assertFalse(mEmailValidator.validate("sometext@sometext"));
        assertFalse(mEmailValidator.validate("a.a.a"));
    }

    public void testValid() {
        assertTrue(mEmailValidator.validate("test@valid.hu"));
    }
}
