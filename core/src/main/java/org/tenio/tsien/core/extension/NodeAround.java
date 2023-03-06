package org.tenio.tsien.core.extension;

import org.tenio.tsien.core.ExecutionContext;
import org.tenio.tsien.core.Node;
import org.tenio.tsien.core.NodeContext;
import org.tenio.tsien.core.NodeType;

import java.util.Arrays;

public interface NodeAround {

    NodeType[] supports();

    default boolean support(NodeType nodeType) {
        return Arrays.binarySearch(supports(), nodeType) != -1;
    }

    default void onBefore(Node node, ExecutionContext context, NodeContext nodeContext) {
    }

    default void onAfter(Node node, ExecutionContext context, NodeContext nodeContext, int result) {
    }

    default void onError(Node node, ExecutionContext context, NodeContext nodeContext, Throwable tx) {
    }

    default void onComplete(Node node, ExecutionContext context, NodeContext nodeContext) {
    }
}
