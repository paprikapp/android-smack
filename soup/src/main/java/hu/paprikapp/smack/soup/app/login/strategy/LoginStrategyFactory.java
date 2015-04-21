package hu.paprikapp.smack.soup.app.login.strategy;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Balazs Varga
 */
public class LoginStrategyFactory {

    private static LoginStrategyFactory defaultFactory;
    private final HashMap<LoginStrategyId, LoginStrategy> registry = new HashMap<>();

    public static LoginStrategyFactory getDefaultFactory() {
        if (defaultFactory == null) {
            // TODO Is it necessary? Always check the default factory configuration.
            throw new RuntimeException("The default factory did not be configured.");
        }
        return defaultFactory;
    }

    public static void setDefaultFactory(@NonNull LoginStrategyFactory factory) {
        defaultFactory = factory;
    }

    public final LoginStrategy strategyById(LoginStrategyId strategyId)
    {
        Map<LoginStrategyId, LoginStrategy> registry = all();

        if (!registry.containsKey(strategyId)) {
            throw new RuntimeException(String.format("Strategy is not registered: %s", strategyId));
        }
        return registry.get(strategyId);
    }

    public final Map<LoginStrategyId, LoginStrategy> all() {
        return registry;
    }

    public final void registerStrategy(LoginStrategyId id, LoginStrategy strategy) {
        registry.put(id, strategy);
    }
}
