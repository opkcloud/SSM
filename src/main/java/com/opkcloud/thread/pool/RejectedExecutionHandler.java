package com.opkcloud.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecutionHandler implements java.util.concurrent.RejectedExecutionHandler {

    private static Logger logger = LoggerFactory.getLogger(RejectedExecutionHandler.class);

    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        logger.error(runnable.toString() + " : has rejected");
    }

}
