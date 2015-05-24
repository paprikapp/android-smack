package hu.paprikapp.smack.soup.app.login;

import android.support.annotation.NonNull;
import android.view.View;

import java.lang.ref.WeakReference;

import hu.paprikapp.smack.soup.app.SmackFragment;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategyId;

/**
 * @author Balazs Varga
 */
class SmackLoginButtonClickListener implements View.OnClickListener {
    private final WeakReference<SmackFragment> mWeakFragment;
    private final LoginStrategyId mLoginStrategyId;

    public SmackLoginButtonClickListener(@NonNull SmackFragment fragment, @NonNull final LoginStrategyId loginStrategyId) {
        mWeakFragment = new WeakReference<>(fragment);
        mLoginStrategyId = loginStrategyId;
    }

    @Override
    public void onClick(View v) {
        SmackFragment fragment = mWeakFragment.get();
        fragment.startLoading();
        LoginDispatcher dispatcher = new DefaultLoginDispatcher(mLoginStrategyId);
        // TODO need an unregistered user instance for second parameter.
        dispatcher.dispatch(fragment, null);
    }
}