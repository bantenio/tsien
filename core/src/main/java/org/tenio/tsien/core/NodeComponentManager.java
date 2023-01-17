package org.tenio.tsien.core;

public interface NodeComponentManager {

    <T extends NodeComponent> T findNodeComponent(Class<T> clazz);

    <T extends NodeComponent> T findNodeComponent(String name, Class<T> clazz);
}
