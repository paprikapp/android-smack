package hu.paprikapp.smack.soup.app.login.dispatcher;

import android.support.v4.app.Fragment;

import hu.paprikapp.smack.soup.app.login.SmackLoginCallback;
import hu.paprikapp.smack.soup.app.login.SmackUser;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategy;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategyFactory;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategyId;
import hu.paprikapp.smack.soup.app.login.strategy.SimpleLoginStrategyCallback;
import hu.paprikapp.smack.soup.net.Net;
import hu.paprikapp.smack.soup.util.dialog.Dialog;

/**
 * @author Balazs Varga
 */
public class DefaultLoginDispatcher implements LoginDispatcher {

    private final LoginStrategyId strategyId;

    public DefaultLoginDispatcher(LoginStrategyId strategyId) {
        this.strategyId = strategyId;
    }

    @Override
    public void dispatch(Fragment fragment, SmackUser user) {
        if (Net.isNotConnected()) {
            Dialog.showNeedInternetDialogFragment(fragment.getChildFragmentManager());
        } else {
            LoginStrategyFactory factory = LoginStrategyFactory.getDefaultFactory();
            LoginStrategy strategy = factory.strategyById(strategyId);
            SimpleLoginStrategyCallback callback = new SimpleLoginStrategyCallback(getCallback(fragment));
            strategy.login(fragment, user, callback);
        }
    }

    private SmackLoginCallback getCallback(Fragment fragment) {
        if (fragment instanceof SmackLoginCallback) {
            return (SmackLoginCallback)fragment;
        }
        return null;
    }
}
