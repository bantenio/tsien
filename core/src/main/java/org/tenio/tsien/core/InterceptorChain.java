package org.tenio.tsien.core;

public interface InterceptorChain {
    int next(ExecutionContext context, Node<NodeContext> node, NodeContext nodeContext, InterceptorChain interceptorChain) throws Throwable;
}
