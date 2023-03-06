package org.tenio.tsien.core.component;

public interface ComponentManager {

    <T extends Component> T findComponent(Class<T> clazz);

    <T extends Component> T findComponent(String name, Class<T> clazz);
}
