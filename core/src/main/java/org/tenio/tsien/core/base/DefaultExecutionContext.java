package org.tenio.tsien.core.base;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DefaultExecutionContext implements ExecutionContext {
    private Map<String, Object> context;

    private Throwable throwable;

    public DefaultExecutionContext() {
        context = new HashMap<>();
    }

    public DefaultExecutionContext(Map<String, Object> context) {
        this.context = context;
    }

    @Override
    public Map<String, Object> getContext() {
        return context;
    }

    @Override
    public ExecutionContext setContext(Map<String, Object> context) {
        this.context = context;
        return this;
    }

    @Override
    public Throwable getException() {
        return this.throwable;
    }

    @Override
    public ExecutionContext setException(Throwable e) {
        this.throwable = e;
        return this;
    }

    @Override
    public boolean isFailed() {
        return this.throwable != null;
    }

    @Override
    public boolean has(String key) {
        return context.containsKey(key);
    }

    @Override
    public Object get(String key) {
        return context.get(key);
    }

    @Override
    public Object get(String key, Function<String, ?> provider) {
        return this.context.computeIfAbsent(key, provider);
    }

    @Override
    public ExecutionContext set(String key, Object value) {
        this.context.put(key, value);
        return this;
    }
}
