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
