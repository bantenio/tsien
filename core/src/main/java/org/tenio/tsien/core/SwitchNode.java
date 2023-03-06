package org.tenio.tsien.core;

import java.util.List;

public class SwitchNode extends Node<NodeContext> {

    private Node<NodeContext> conditionNode;

    private List<Node<NodeContext>> branchNodes;

    public SwitchNode() {
    }

    public SwitchNode(NodeContext propertyContext) {
        super(propertyContext);
    }

    @Override
    public int execute(ExecutionContext context, NodeContext propertyContext) throws Throwable {
        int branchIndex = invokeConditionNode(context, propertyContext, conditionNode);
        branchIndex = findBranchNode(context, propertyContext, branchNodes, branchIndex);
        Node<NodeContext> branchNode = getBranch(branchIndex);
        invokeBranchNode(context, propertyContext, branchNodes, branchNode, branchIndex);
        return ExecutionResult.COMPONENT_RESULT_ZERO;
    }

    protected int invokeConditionNode(ExecutionContext context,
                                      NodeContext propertyContext,
                                      Node<NodeContext> conditionNode) throws Throwable {
        return conditionNode.execute(context);
    }

    protected int findBranchNode(ExecutionContext context,
                                 NodeContext propertyContext,
                                 List<Node<NodeContext>> branchNodes,
                                 int branchIndex) {
        if (branchIndex == ExecutionResult.COMPONENT_RESULT_MINUS_ONE) {
            branchIndex = branchNodes.size() - 1;
        }
        return branchIndex;
    }

    protected int invokeBranchNode(ExecutionContext context,
                                   NodeContext propertyContext,
                                   List<Node<NodeContext>> branchNodes,
                                   Node<NodeContext> branchNode,
                                   int branchIndex) throws Throwable {
        return branchNode.execute(context);
    }

    public Node<NodeContext> getConditionNode() {
        return conditionNode;
    }

    public SwitchNode setConditionNode(Node<NodeContext> conditionNode) {
        this.conditionNode = conditionNode;
        return this;
    }

    public SwitchNode addBranch(Node<NodeContext> node) {
        branchNodes.add(node);
        return this;
    }

    public SwitchNode removeBranch(int index) {
        branchNodes.remove(index);
        return this;
    }

    public Node<NodeContext> getBranch(int index) {
        return branchNodes.get(index);
    }
}
