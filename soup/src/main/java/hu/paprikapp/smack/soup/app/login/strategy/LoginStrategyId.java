package hu.paprikapp.smack.soup.app.login.strategy;

import android.text.TextUtils;

/**
 * @author Balazs Varga
 */
public class LoginStrategyId {

    private final String strategyId;

    private LoginStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String value() {
        return strategyId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LoginStrategyId) {
            LoginStrategyId strategyId = (LoginStrategyId)o;
            return TextUtils.equals(this.value(), strategyId.value());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value().hashCode();
    }

    @Override
    public String toString() {
        return value();
    }

    public static class Ids {
        public static final LoginStrategyId FACEBOOK = new LoginStrategyId("FACEBOOK");
    }
}
