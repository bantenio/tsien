package org.tenio.tsien.core;

public interface Execution<T extends PropertyContext> {
    /**
     * 执行
     *
     * @param context
     * @param propertyContext
     * @return
     * @throws Throwable
     */
    int execute(ExecutionContext context, T propertyContext) throws Throwable;


    /**
     * 获取配置相关上下文内容
     *
     * @return
     */
    T getPropertyContext();

    /**
     * 执行
     *
     * @param context
     * @return
     * @throws Throwable
     */
    default int execute(ExecutionContext context) throws Throwable {
        return execute(context, getPropertyContext());
    }
}
