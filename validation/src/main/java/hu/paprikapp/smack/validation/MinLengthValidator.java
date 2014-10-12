package hu.paprikapp.smack.validation;

/**
 * @author Balazs Varga
 */
public class MinLengthValidator extends SmackAbstractLengthValidator {

    public MinLengthValidator(String message, int length) {
        super(message, length, false);
    }

    @Override
    public boolean validate(String text) {
        int length = text == null ? 0 : text.length();
        if (length < getLength()) {
            return false;
        }
        return true;
    }
}
