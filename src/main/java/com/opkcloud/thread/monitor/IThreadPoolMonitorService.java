package com.opkcloud.thread.monitor;

import java.util.concurrent.ThreadPoolExecutor;

public interface IThreadPoolMonitorService extends Runnable {

    void monitorThreadPool();

    ThreadPoolExecutor getExecutor();

    void setExecutor(ThreadPoolExecutor executor);
}
