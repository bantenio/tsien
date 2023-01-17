package org.tenio.tsien.core.chain;

import org.tenio.tsien.core.base.DefaultPropertyContext;

public class ChainContext extends DefaultPropertyContext {

    private String name;

    public ChainContext() {
    }

    public ChainContext(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ChainContext setName(String name) {
        this.name = name;
        return this;
    }
}
