package hu.paprikapp.smack.validation;

/**
 * @author Balazs Varga
 */
public abstract class SmackAbstractValidator implements SmackValidator {

    private String mMessage;

    public SmackAbstractValidator(String message) {
        mMessage = message;
    }

    @Override
    public String getMessage() {
        return mMessage;
    }

    @Override
    public void setMessage(String message) {
        mMessage = message;
    }
}
