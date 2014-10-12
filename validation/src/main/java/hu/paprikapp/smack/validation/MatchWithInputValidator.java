package hu.paprikapp.smack.validation;

import android.text.TextUtils;
import android.widget.EditText;

/**
 * @author Balazs Varga
 */
public class MatchWithInputValidator extends SmackAbstractValidator {

    private EditText mMatchWithThis;

    public MatchWithInputValidator(String message, EditText matchWithThis) {
        super(message);
        mMatchWithThis = matchWithThis;
    }

    @Override
    public boolean validate(String text) {
        return TextUtils.equals(mMatchWithThis.getText(), text);
    }
}
