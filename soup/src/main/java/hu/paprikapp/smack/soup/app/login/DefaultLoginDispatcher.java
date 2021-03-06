package hu.paprikapp.smack.soup.app.login;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategy;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategyFactory;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategyId;
import hu.paprikapp.smack.soup.app.login.strategy.SimpleLoginStrategyCallback;
import hu.paprikapp.smack.soup.net.Net;
import hu.paprikapp.smack.soup.util.dialog.SmackDialog;

/**
 * @author Balazs Varga
 */
class DefaultLoginDispatcher implements LoginDispatcher {

    private final LoginStrategyId mLoginStrategyId;

    public DefaultLoginDispatcher(final LoginStrategyId loginStrategyId) {
        mLoginStrategyId = loginStrategyId;
    }

    @Override
    public void dispatch(Fragment fragment, SmackUser user) {
        if (Net.isNotConnected()) {
            SmackDialog.showNeedInternetDialogFragment(fragment.getChildFragmentManager());
        } else {
            LoginStrategyFactory factory = LoginStrategyFactory.getDefaultFactory();
            LoginStrategy strategy = factory.strategyById(mLoginStrategyId);
            SimpleLoginStrategyCallback callback = new SimpleLoginStrategyCallback(getCallback(fragment));
            callback.start();
            strategy.login(fragment, user, callback);
        }
    }

    @Nullable
    private SmackLoginCallback getCallback(Fragment fragment) {
        if (fragment instanceof SmackLoginCallback) {
            return (SmackLoginCallback) fragment;
        }
        return null;
    }
}
