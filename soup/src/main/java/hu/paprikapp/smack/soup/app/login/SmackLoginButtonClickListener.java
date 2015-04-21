package hu.paprikapp.smack.soup.app.login;

import android.support.annotation.NonNull;
import android.view.View;

import java.lang.ref.WeakReference;

import hu.paprikapp.smack.soup.app.SmackFragment;
import hu.paprikapp.smack.soup.app.login.dispatcher.DefaultLoginDispatcher;
import hu.paprikapp.smack.soup.app.login.dispatcher.LoginDispatcher;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategyId;

/**
 * @author Balazs Varga
 */
class SmackLoginButtonClickListener implements View.OnClickListener {
    private WeakReference<SmackFragment> weakFragment;
    private final LoginStrategyId strategyId;

    public SmackLoginButtonClickListener(@NonNull SmackFragment fragment, LoginStrategyId strategyId) {
        this.weakFragment = new WeakReference<>(fragment);
        this.strategyId = strategyId;
    }

    @Override
    public void onClick(View v) {
        SmackFragment fragment = weakFragment.get();
        LoginDispatcher dispatcher = new DefaultLoginDispatcher(strategyId);
        // TODO need an unregistered user instance for second parameter.
        dispatcher.dispatch(fragment, null);
    }
}