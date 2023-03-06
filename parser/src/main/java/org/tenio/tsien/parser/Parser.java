package org.tenio.tsien.parser;

import org.tenio.tsien.core.Chain;
import org.tenio.tsien.core.ChainManager;

public interface Parser {

    Chain parse(String chainPath);

    ChainManager config(String chainManagerPath);
}
