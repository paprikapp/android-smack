package hu.paprikapp.smack.validation.inputs;

import java.util.ArrayList;
import java.util.List;

import hu.paprikapp.smack.validation.SmackValidator;

/**
 * @author Balazs Varga
 */
public abstract class SmackAbstractInputValidator implements SmackInputValidator {

    private final List<SmackValidator> mValidators = new ArrayList<SmackValidator>();

    @Override
    public final void addValidator(SmackValidator validator) {
        mValidators.add(validator);
    }

    @Override
    public final List<SmackValidator> validators() {
        return mValidators;
    }

    protected final boolean validate(String text) {
        for (SmackValidator validator : mValidators) {
            if (!validator.validate(text)) {
                showError(validator.getMessage());
                return false;
            }
        }
        hideError();
        return true;
    }
}
