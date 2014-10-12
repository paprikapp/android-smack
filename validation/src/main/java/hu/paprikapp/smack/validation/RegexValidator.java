package hu.paprikapp.smack.validation;

import android.support.annotation.NonNull;

import java.util.regex.Pattern;

/**
 * @author Balazs Varga
 */
public class RegexValidator extends SmackAbstractValidator {

    public String mPattern;

    public RegexValidator(String message, @NonNull String pattern) {
        super(message);
        mPattern = pattern;
    }

    public String getPattern() {
        return mPattern;
    }

    public void setPattern(@NonNull String pattern) {
        mPattern = pattern;
    }

    @Override
    public boolean validate(String text) {
        Pattern exp = Pattern.compile(mPattern);

        if (exp.matcher(text).matches()) {
            return true;
        }
        return false;
    }
}
