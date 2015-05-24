package hu.paprikapp.smack.soup.app.login.strategy;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Balazs Varga
 */
public class LoginStrategyFactory {

    private static LoginStrategyFactory mDefaultFactory;
    private final HashMap<LoginStrategyId, LoginStrategy> mRegistry = new HashMap<>();

    public static LoginStrategyFactory getDefaultFactory() {
        if (mDefaultFactory == null) {
            throw new RuntimeException("The default factory did not be configured.");
        }
        return mDefaultFactory;
    }

    public static void setDefaultFactory(@NonNull LoginStrategyFactory loginStrategyFactory) {
        mDefaultFactory = loginStrategyFactory;
    }

    public final LoginStrategy strategyById(@NonNull LoginStrategyId loginStrategyId) {
        Map<LoginStrategyId, LoginStrategy> registry = all();

        if (!registry.containsKey(loginStrategyId)) {
            throw new RuntimeException(String.format("Strategy is not registered: %s", loginStrategyId));
        }
        return registry.get(loginStrategyId);
    }

    public final Map<LoginStrategyId, LoginStrategy> all() {
        return mRegistry;
    }

    public final void registerStrategy(@NonNull LoginStrategyId loginStrategyId, @NonNull LoginStrategy loginStrategy) {
        mRegistry.put(loginStrategyId, loginStrategy);
    }
}
