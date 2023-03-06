package org.tenio.tsien.core;

import java.util.List;

public class DefaultInterceptorChain implements InterceptorChain {

    private int currentIndex = 0;

    private List<Interceptor> interceptorList = null;

    public DefaultInterceptorChain(List<Interceptor> interceptorList) {
        this.interceptorList = interceptorList;
    }

    @Override
    public int next(ExecutionContext context, Node<NodeContext> node, NodeContext nodeContext, InterceptorChain interceptorChain) throws Throwable {
        if (currentIndex == interceptorList.size()) {
            return node.execute(context);
        }
        return interceptorList.get(currentIndex++).process(context, node, nodeContext, interceptorChain);
    }
}
