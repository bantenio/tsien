package org.tenio.tsien.core.component;

import org.tenio.tsien.core.ExecutionContext;
import org.tenio.tsien.core.ExecutionResult;
import org.tenio.tsien.core.NodeContext;

public interface Component {

    default int execute(ExecutionContext context, NodeContext nodeContext) throws Throwable {
        handle(context, nodeContext);
        return ExecutionResult.COMPONENT_RESULT_ZERO;
    }

    void handle(ExecutionContext context, NodeContext nodeContext) throws Throwable;
}
