package org.tenio.tsien.core;

import org.tenio.tsien.exceptions.NotSupportNullException;

import java.util.ArrayList;
import java.util.List;

public class Chain extends Node<NodeContext> {
    private Node<NodeContext> finallyNode = null;
    private Node<NodeContext> catchNode = null;
    private List<Node<NodeContext>> nodeList = new ArrayList<>();

    public Chain() {
    }

    public Chain(NodeContext nodeContext) {
        super(nodeContext);
    }

    @Override
    public int execute(ExecutionContext context, NodeContext propertyContext) throws Throwable {
        invokeNodes(context, propertyContext, nodeList);
        if (hasCatch() && context.isFailed()) {
            invokeCatch(context, propertyContext, catchNode);
        }
        if (hasFinally()) {
            invokeFinally(context, propertyContext, finallyNode);
        }
        if (context.isFailed()) {
            throw context.getError();
        }
        return ExecutionResult.COMPONENT_RESULT_ZERO;
    }

    protected void invokeNodes(ExecutionContext context, NodeContext propertyContext, List<Node<NodeContext>> nodeList) {
        if (nodeList.isEmpty()) {
            return;
        }
        try {
            for (Node<NodeContext> node : nodeList) {
                invokeNode(context, propertyContext, node);
            }
        } catch (Throwable t) {
            context.setError(t);
        }
    }

    protected int invokeNode(ExecutionContext context, NodeContext propertyContext, Node<NodeContext> node) throws Throwable {
        return node.execute(context);
    }

    protected void invokeCatch(ExecutionContext context, NodeContext propertyContext, Node<NodeContext> node) throws Throwable {
        invokeNode(context, propertyContext, node);
    }

    protected void invokeFinally(ExecutionContext context, NodeContext propertyContext, Node<NodeContext> node) throws Throwable {
        invokeNode(context, propertyContext, node);
    }

    public Chain addNode(Node<NodeContext> node) {
        if (node == null) {
            throw new NotSupportNullException("The node is null");
        }
        nodeList.add(node);
        return this;
    }

    public Chain removeNode(int index) {
        nodeList.remove(index);
        return this;
    }

    public Chain finallyNode(Node<NodeContext> finallyNode) {
        this.finallyNode = finallyNode;
        return this;
    }

    public boolean hasFinally() {
        return this.finallyNode != null;
    }

    public Node<NodeContext> finallyNode() {
        return this.finallyNode;
    }

    public Chain catchNode(Node<NodeContext> finallyNode) {
        this.catchNode = finallyNode;
        return this;
    }

    public boolean hasCatch() {
        return this.catchNode != null;
    }

    public Node<NodeContext> catchNode() {
        return this.catchNode;
    }
}
