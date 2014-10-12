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
