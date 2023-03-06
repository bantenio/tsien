package org.tenio.tsien.core;

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

    public void setId(String id) {
        this.id = id;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }
}
