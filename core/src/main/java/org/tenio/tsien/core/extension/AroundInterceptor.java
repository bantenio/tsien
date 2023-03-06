package org.tenio.tsien.core.extension;

import org.tenio.tsien.core.*;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class AroundInterceptor extends AbstractInterceptor {
    private Set<NodeAround> nodeAroundSet = new HashSet<>(16);

    public AroundInterceptor(String id) {
        super(id);
    }

    public AroundInterceptor registerAround(NodeAround nodeAround) {
        nodeAroundSet.add(nodeAround);
        return this;
    }

    public AroundInterceptor unregisterAround(NodeAround nodeAround) {
        nodeAroundSet.remove(nodeAround);
        return this;
    }

    @Override
    public int process(ExecutionContext context,
                       Node<NodeContext> node,
                       NodeContext nodeContext,
                       InterceptorChain interceptorChain) throws Throwable {
        NodeType nodeType = nodeContext.getNodeType();
        invokeNodeAround(nodeAroundSet, nodeType, nodeAround -> nodeAround.onBefore(node, context, nodeContext));
        try {
            int result = interceptorChain.next(context, node, nodeContext, interceptorChain);
            invokeNodeAround(nodeAroundSet, nodeType, nodeAround -> nodeAround.onAfter(node, context, nodeContext, result));
        } catch (Throwable e) {
            invokeNodeAround(nodeAroundSet, nodeType, nodeAround -> nodeAround.onError(node, context, nodeContext, e));
        } finally {
            invokeNodeAround(nodeAroundSet, nodeType, nodeAround -> nodeAround.onComplete(node, context, nodeContext));
        }

        return 0;
    }

    protected void invokeNodeAround(Set<NodeAround> nodeAroundSet,
                                    NodeType nodeType,
                                    Consumer<NodeAround> consumer) {
        for (NodeAround nodeAround : nodeAroundSet) {
            if (nodeAround.support(nodeType)) {
                consumer.accept(nodeAround);
            }
        }
    }
}
