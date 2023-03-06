package org.tenio.tsien.core;

import java.util.Set;
import java.util.function.Function;

public interface PropertyContext {

    // region property functions
    boolean hasProperty(String key);

    Object getProperty(String key);

    Object getProperty(String key, Function<String, ?> provider);

    default <T> T getPropertyByType(String key) {
        return (T) getProperty(key);
    }

    default <T> T getPropertyByType(String key, Function<String, T> provider) {
        return (T) getProperty(key, provider);
    }

    void setProperty(String key, Object value);

    Set<String> propertyKeys();
    // endregion
}
