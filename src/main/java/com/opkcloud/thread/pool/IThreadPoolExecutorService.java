package com.opkcloud.thread.pool;

import java.util.concurrent.ThreadPoolExecutor;

public interface IThreadPoolExecutorService {

    ThreadPoolExecutor createNewThreadPool();
    int getCorePoolSize();
    void setCorePoolSize(int corePoolSize);
    int getMaxPoolSize();
    void setMaxPoolSize(int maxPoolSize);
    long getKeepAliveTime();
    void setKeepAliveTime(long keepAliveTime);
    int getQueueCapacity();
    void setQueueCapacity(int queueCapacity);
    RejectedExecutionHandler getRejectedExecutionHandler();
    void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler);

}
