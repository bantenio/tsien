package org.tenio.tsien.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DefaultChainManager implements ChainManager {
    private static final Logger log = LoggerFactory.getLogger(DefaultChainManager.class);
    private Map<String, Chain> chainMap = new HashMap<>();

    @Override
    public void addChain(Chain chain) {
        String id = chain.getPropertyContext().getId();
        if (chainMap.containsKey(id) && log.isWarnEnabled()) {
            log.warn("The chain '{}' is existed in chain manager.", id);
        }
        chainMap.put(id, chain);
    }
}
