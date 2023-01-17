package org.tenio.tsien.core.chain;

import org.tenio.tsien.core.base.DefaultPropertyContext;

public class NodeContext extends DefaultPropertyContext {

    private String id;

    private NodeType nodeType;

    public NodeContext() {
    }

    public NodeContext(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public NodeContext setId(String id) {
        this.id = id;
        return this;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public NodeContext setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
        return this;
    }
}
