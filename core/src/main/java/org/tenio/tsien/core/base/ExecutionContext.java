package org.tenio.tsien.core.base;

import java.util.Map;
import java.util.function.Function;

public interface ExecutionContext {

    Map<String, Object> getContext();

    ExecutionContext setContext(Map<String, Object> context);

    Throwable getException();

    ExecutionContext setException(Throwable e);

    boolean isFailed();

    boolean has(String key);

    Object get(String key);

    Object get(String key, Function<String, ?> provider);

    default <T> T byType(String key) {
        return (T) get(key);
    }

    default <T> T byType(String key, Function<String, T> provider) {
        return (T) get(key, provider);
    }

    ExecutionContext set(String key, Object value);
}
