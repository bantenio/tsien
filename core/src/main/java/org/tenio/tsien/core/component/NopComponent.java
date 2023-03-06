package org.tenio.tsien.core.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tenio.tsien.core.ExecutionContext;
import org.tenio.tsien.core.NodeContext;

public class NopComponent implements Component {

    Logger log = LoggerFactory.getLogger(NopComponent.class);

    @Override
    public void handle(ExecutionContext context, NodeContext nodeContext) throws Throwable {
        if (log.isTraceEnabled()) {
            log.trace("The '{}' NoResultComponent executing...", nodeContext.getId());
        }
    }
}
