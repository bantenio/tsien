package org.tenio.tsien.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tenio.tsien.core.base.ExecutionContext;
import org.tenio.tsien.core.chain.NodeContext;

import static org.tenio.tsien.core.base.ExecutionResult.COMPONENT_RESULT_ZERO;

public class NopNodeComponent implements NodeComponent {

    Logger log = LoggerFactory.getLogger(NopNodeComponent.class);

    @Override
    public int execute(ExecutionContext context, NodeContext nodeContext) throws Throwable {
        if (log.isTraceEnabled()) {
            log.trace("The '{}' NopNodeComponent executing...", nodeContext.getId());
        }
        return COMPONENT_RESULT_ZERO;
    }

}
