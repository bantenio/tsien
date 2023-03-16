package org.tenio.tsien.parser.groovy.dsl

import org.tenio.tsien.core.ChainManager
import org.tenio.tsien.core.DefaultChainManager
import org.tenio.tsien.parser.groovy.GyfParser

abstract class ChainManagerConfigScript extends Script {

    private DefaultChainManager chainManager = new DefaultChainManager()

    private GyfParser parser

    void setParser(GyfParser gyfParser) {
        this.parser = gyfParser
    }

    void chain(String chainPath) {
        chainManager.addChain(parser.parse(chainPath))
    }

    ChainManager getChainManager() {
        return this.chainManager
    }
}
