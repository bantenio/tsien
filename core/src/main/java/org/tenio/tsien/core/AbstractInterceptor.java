package org.tenio.tsien.core;

public abstract class AbstractInterceptor implements Interceptor {
    private String id;

    public AbstractInterceptor(String id) {
        this.id = id;
    }

    public AbstractInterceptor setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
