package org.tenio.tsien.core.base;

public interface Execution {
    /**
     * 执行
     * @param executionContext
     * @return
     * @throws Throwable
     */
    int execute(ExecutionContext executionContext) throws Throwable;
}
