package org.tenio.tsien.core.chain;

import org.tenio.tsien.core.NodeComponent;
import org.tenio.tsien.core.base.Execution;
import org.tenio.tsien.core.base.ExecutionContext;

public class Node implements Execution {
    private NodeContext nodeContext;
    private NodeComponent nodeComponent;

    public Node() {
    }

    public Node(NodeContext nodeContext) {
        this.nodeContext = nodeContext;
    }

    public Node(NodeComponent nodeComponent) {
        this.nodeComponent = nodeComponent;
    }

    public Node(NodeContext nodeContext, NodeComponent nodeComponent) {
        this.nodeContext = nodeContext;
        this.nodeComponent = nodeComponent;
    }

    public NodeComponent getNodeComponent() {
        return this.nodeComponent;
    }

    public Node setNodeComponent(NodeComponent nodeComponent) {
        this.nodeComponent = nodeComponent;
        return this;
    }

    @Override
    public int execute(ExecutionContext executionContext) throws Throwable {
        return nodeComponent.execute(executionContext, nodeContext);
    }
}
