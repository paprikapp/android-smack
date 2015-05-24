package hu.paprikapp.smack.soup.app.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import hu.paprikapp.smack.soup.R;
import hu.paprikapp.smack.soup.app.FragmentCreator;
import hu.paprikapp.smack.soup.app.SmackFragment;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategy;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategyFactory;
import hu.paprikapp.smack.soup.app.login.strategy.LoginStrategyId;

/**
 * Custom fragment for some login methods.
 * Currently supported:
 *  - Facebook authentication:
 *      Requirements: need put a Button with R.string.smack_facebook_button identifier to custom login layout.
 * @author Balazs Varga
 */
public class SmackLoginFragment extends SmackFragment implements SmackLoginCallback {

    private SmackLoginCallback mLoginCallback;

    /**
     * Makes a new SmackLoginFragment instance.
     * @param context Context for create new instance.
     * @param layoutId Custom layout id for login screen.
     * @return
     */
    public static SmackLoginFragment newInstance(@NonNull Context context, @LayoutRes int layoutId) {
        return FragmentCreator.create(context, SmackLoginFragment.class, layoutId);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof SmackLoginCallback) {
            mLoginCallback = (SmackLoginCallback)activity;
        }
    }

    @Override
    public void onDetach() {
        mLoginCallback = null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configureFbButton(view);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        handleOnActivityResult(requestCode, resultCode, data);
    }

    /**
     * Finds the facebook button. if its available on layout, will configure with on click listener, which attempts the facebook authentication after click.
     * @param view The content view, need for find the facebook button in layout.
     */
    private void configureFbButton(@NonNull View view) {
        Button fbLoginButton = (Button)view.findViewById(R.id.smack_facebook_button);

        if (fbLoginButton != null) {
            fbLoginButton.setOnClickListener(new SmackLoginButtonClickListener(this, LoginStrategyId.Ids.FACEBOOK));
        }
    }

    /**
     * Handle activity results on all attached LoginStrategy.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    private void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        LoginStrategyFactory factory = LoginStrategyFactory.getDefaultFactory();
        for (LoginStrategy strategy : factory.all().values()) {
            strategy.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void success(SmackUser user) {
        if (mLoginCallback != null) {
            mLoginCallback.success(user);
        }
    }

    @Override
    public void failed(Exception error) {
        if (mLoginCallback != null) {
            mLoginCallback.failed(error);
        }
    }

    @Override
    public void canceled() {
        if (mLoginCallback != null) {
            mLoginCallback.canceled();
        }
    }
}
