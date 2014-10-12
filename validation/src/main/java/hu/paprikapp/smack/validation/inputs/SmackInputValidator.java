package hu.paprikapp.smack.validation.inputs;

import java.util.List;

import hu.paprikapp.smack.validation.SmackValidator;

/**
 * @author Balazs Varga
 */
public interface SmackInputValidator {

    void addValidator(SmackValidator validator);
    List<SmackValidator> validators();
    boolean validate();

    void showError(String message);
    void hideError();
}
