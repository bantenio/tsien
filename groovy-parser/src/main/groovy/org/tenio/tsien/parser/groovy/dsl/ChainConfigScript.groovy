package org.tenio.tsien.parser.groovy.dsl

import org.tenio.tsien.core.Chain

abstract class ChainConfigScript extends Script {
    private final Chain chain = new Chain()

    Chain getChain() {
        return chain
    }
}
