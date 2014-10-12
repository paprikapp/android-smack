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
