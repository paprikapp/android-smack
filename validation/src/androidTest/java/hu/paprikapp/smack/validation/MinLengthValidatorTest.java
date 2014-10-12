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
