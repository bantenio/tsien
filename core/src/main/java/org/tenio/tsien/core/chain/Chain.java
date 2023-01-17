package org.tenio.tsien.core.chain;

import org.tenio.tsien.core.base.Execution;
import org.tenio.tsien.core.base.ExecutionContext;

public abstract class Chain implements Execution {
    private ChainContext chainContext;

    public Chain() {
    }

    public Chain(ChainContext chainContext) {
        this.chainContext = chainContext;
    }

    public ChainContext getChainContext() {
        return chainContext;
    }

    public Chain setChainContext(ChainContext chainContext) {
        this.chainContext = chainContext;
        return this;
    }

    public String getName(ChainContext chainContext) {
        return chainContext.getName();
    }

    @Override
    public int execute(ExecutionContext executionContext) throws Throwable {
        return execute(executionContext, chainContext);
    }

    public abstract int execute(ExecutionContext context, ChainContext chainContext) throws Throwable;
}
