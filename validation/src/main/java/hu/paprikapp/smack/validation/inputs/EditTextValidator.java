package hu.paprikapp.smack.validation.inputs;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * @author Balazs Varga
 */
public class EditTextValidator  extends SmackAbstractInputValidator implements TextWatcher {

    private EditText mEditText;

    public EditTextValidator(@NonNull EditText editText) {
        mEditText = editText;
    }

    ///
    /// TextWatcher interface methods
    ///

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        validate();
    }

    ///
    /// SmackInputValidator interface methods
    ///

    @Override
    public boolean validate() {
        return validate(String.valueOf(mEditText.getText()));
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void hideError() {

    }
}
