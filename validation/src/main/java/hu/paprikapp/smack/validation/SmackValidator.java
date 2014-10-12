package hu.paprikapp.smack.validation;

/**
 * @author Balazs Varga
 */
public interface SmackValidator {

    String getMessage();

    void setMessage(final String message);

    boolean validate(final String text);
}
