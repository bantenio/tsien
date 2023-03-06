package org.tenio.tsien.core.base;

import org.tenio.tsien.core.Node;
import org.tenio.tsien.core.NodeContext;

public class ExecutionContextStackItem {

    private String nodeId;

    private int status;

    private int nodeType;

    public ExecutionContextStackItem() {
    }

    public ExecutionContextStackItem(Node<NodeContext> node) {
        NodeContext nodeContext = node.getPropertyContext();
        this.setNodeId(nodeContext.getId())
                .setNodeType(nodeContext.getNodeType().getTypeValue());
    }

    public ExecutionContextStackItem(String nodeId) {
        this.nodeId = nodeId;
    }

    public ExecutionContextStackItem(String nodeId, int nodeType) {
        this.nodeId = nodeId;
        this.nodeType = nodeType;
    }

    public ExecutionContextStackItem(String nodeId, int nodeType, int status) {
        this.nodeId = nodeId;
        this.nodeType = nodeType;
        this.status = status;
    }

    public String getNodeId() {
        return nodeId;
    }

    public ExecutionContextStackItem setNodeId(String nodeId) {
        this.nodeId = nodeId;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ExecutionContextStackItem setStatus(int status) {
        this.status = status;
        return this;
    }

    public int getNodeType() {
        return nodeType;
    }

    public ExecutionContextStackItem setNodeType(int nodeType) {
        this.nodeType = nodeType;
        return this;
    }
}
