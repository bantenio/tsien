package org.tenio.tsien.core.component;

import cn.hutool.core.text.CharSequenceUtil;
import org.tenio.tsien.core.ExecutionContext;
import org.tenio.tsien.core.Node;
import org.tenio.tsien.core.NodeContext;
import org.tenio.tsien.exceptions.NotSupportNullException;

public class ComponentNode extends Node<NodeContext> {
    private Component component;

    public ComponentNode() {
    }

    public ComponentNode(Component component) {
        this.component = component;
    }

    public ComponentNode(NodeContext propertyContext, Component component) {
        super(propertyContext);
        this.component = component;
    }

    public Component getComponent() {
        return component;
    }

    public ComponentNode setComponent(Component component) {
        this.component = component;
        return this;
    }

    @Override
    public int execute(ExecutionContext context, NodeContext propertyContext) throws Throwable {
        if (component == null) {
            throw new NotSupportNullException(CharSequenceUtil.format("The component is null in '{}' node.", propertyContext.getId()));
        }
        return component.execute(context, propertyContext);
    }
}
