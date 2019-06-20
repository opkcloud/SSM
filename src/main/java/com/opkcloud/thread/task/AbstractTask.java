package com.opkcloud.thread.task;

public abstract class AbstractTask implements Runnable {

    public abstract void task();

    @Override
    public void run() {
        task();
    }
}
