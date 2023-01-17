package org.tenio.tsien.core.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class DefaultPropertyContext implements PropertyContext<DefaultPropertyContext> {

    private final Map<String, Object> context = new HashMap<>();

    // region property functions
    public boolean hasProperty(String key) {
        return context.containsKey(key);
    }

    public Object getProperty(String key) {
        return context.get(key);
    }

    public Object getProperty(String key, Function<String, ?> provider) {
        return this.context.computeIfAbsent(key, provider);
    }

    public DefaultPropertyContext setProperty(String key, Object value) {
        this.context.put(key, value);
        return this;
    }

    public Set<String> propertyKeys() {
        return context.keySet();
    }
    // endregion
}
