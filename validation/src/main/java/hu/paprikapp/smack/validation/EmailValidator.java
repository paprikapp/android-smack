package hu.paprikapp.smack.validation;

import android.support.annotation.NonNull;

/**
 * @author Balazs Varga
 */
public class EmailValidator extends RegexValidator {

    private static final String EMAIL_PATTERN = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+";

    public EmailValidator(String message) {
        super(message, EMAIL_PATTERN);
    }

    @Override
    public void setPattern(@NonNull String pattern) {
        throw new UnsupportedOperationException("This methot is not allowed in this context. Try the RegexValidator.");
    }
}
