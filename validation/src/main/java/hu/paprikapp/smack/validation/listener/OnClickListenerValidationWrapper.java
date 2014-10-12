package hu.paprikapp.smack.validation.listener;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import hu.paprikapp.smack.validation.inputs.SmackValidationForm;

/**
 * @author Balazs Varga
 */
public class OnClickListenerValidationWrapper implements View.OnClickListener {

    private SmackValidationForm mValidationForm;
    private View.OnClickListener mOnClickListener;

    public OnClickListenerValidationWrapper(@NonNull SmackValidationForm validationForm, @Nullable View.OnClickListener listener) {
        mValidationForm = validationForm;
        mOnClickListener = listener;
    }

    @Override
    public void onClick(View v) {

        if (!mValidationForm.validate())
            return;

        if (mOnClickListener != null) {
            mOnClickListener.onClick(v);
        }
    }
}
