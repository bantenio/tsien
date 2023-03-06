package org.tenio.tsien.core;

public interface Interceptor {

    String getId();

    int process(ExecutionContext context, Node<NodeContext> node, NodeContext nodeContext, InterceptorChain interceptorChain) throws Throwable;
}
