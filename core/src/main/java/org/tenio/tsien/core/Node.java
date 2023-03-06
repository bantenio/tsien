package org.tenio.tsien.core;

public abstract class Node<T extends NodeContext> implements Execution<T> {
    private T propertyContext;

    protected Node() {
    }

    protected Node(T propertyContext) {
        this.propertyContext = propertyContext;
    }

    @Override
    public T getPropertyContext() {
        return propertyContext;
    }

    public void setPropertyContext(T propertyContext) {
        this.propertyContext = propertyContext;
    }
}
