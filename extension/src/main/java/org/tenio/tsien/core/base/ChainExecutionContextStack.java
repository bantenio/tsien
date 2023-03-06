package org.tenio.tsien.core.base;

import org.tenio.tsien.core.Chain;
import org.tenio.tsien.core.Node;
import org.tenio.tsien.core.NodeContext;
import org.tenio.tsien.core.NodeType;

import java.util.ArrayList;
import java.util.List;

public class ChainExecutionContextStack extends ExecutionContextStackItem {

    private List<ExecutionContextStackItem> itemList;

    public ChainExecutionContextStack(String nodeId) {
        this(nodeId, 32);
    }

    protected ChainExecutionContextStack(String nodeId, int size) {
        super(nodeId, NodeType.Chain.getTypeValue());
        this.itemList = new ArrayList<>(size);
    }

    public ChainExecutionContextStack add(Node node) {
        NodeContext nodeContext = node.getPropertyContext();
        itemList.add(new ExecutionContextStackItem(nodeContext.getId(), nodeContext.getNodeType().getTypeValue()));
        return this;
    }

    public ChainExecutionContextStack add(Chain chain) {
        NodeContext chainContext = chain.getPropertyContext();
        itemList.add(new ChainExecutionContextStack(chainContext.getId()));
        return this;
    }
}
