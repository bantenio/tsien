package org.tenio.tsien.core;

import org.tenio.tsien.core.base.ExecutionContext;
import org.tenio.tsien.core.chain.NodeContext;

public interface NodeComponent {

    int execute(ExecutionContext context, NodeContext nodeContext) throws Throwable;
}
