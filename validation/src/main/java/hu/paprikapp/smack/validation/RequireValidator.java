package hu.paprikapp.smack.validation;

import android.text.TextUtils;

/**
 * @author Balázs Varga
 */
public class RequireValidator extends SmackAbstractValidator {

    public RequireValidator(String message) {
        super(message);
    }

    @Override
    public boolean validate(String text) {
        if (TextUtils.isEmpty(text) || TextUtils.getTrimmedLength(text) == 0) {
            return false;
        }
        return true;
    }
}
