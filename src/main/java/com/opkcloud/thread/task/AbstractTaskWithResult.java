package com.opkcloud.thread.task;

import java.util.concurrent.Callable;

public abstract class AbstractTaskWithResult<T> implements Callable<T> {
    public abstract T task();

    @Override
    public T call() throws Exception {
        return task();
    }
}
