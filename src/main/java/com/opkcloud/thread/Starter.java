package com.opkcloud.thread;

import com.opkcloud.thread.monitor.IThreadPoolMonitorService;
import com.opkcloud.thread.pool.IThreadPoolExecutorService;
import com.opkcloud.thread.task.AbstractTask;
import com.opkcloud.thread.task.AbstractTaskWithResult;
import com.opkcloud.util.ResultData;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Starter {

    private static Logger logger = LoggerFactory.getLogger(Starter.class);

    private IThreadPoolMonitorService threadPoolMonitorService;
    private IThreadPoolExecutorService threadPoolExecutorService;
    private ThreadPoolExecutor executor;
    private int timeOut = 5000;

    public void init() {
        executor = threadPoolExecutorService.createNewThreadPool();
        executor.allowCoreThreadTimeOut(true);

        threadPoolMonitorService.setExecutor(executor);

        Thread monitor = new Thread(threadPoolMonitorService);
        monitor.start();
    }

    public void start(List<AbstractTask> tasks) {
        if (null != tasks && tasks.size() > 0) {
            // tasks are executed...
            for (int i = 0; i< tasks.size(); i++) {
                executor.execute(tasks.get(i));
            }
        }
    }

    /**
     * 批量启动线程
     * @param tasks
     * @param <T>
     * @return
     */
    public <T> List<T> startWithResult(List<AbstractTaskWithResult> tasks) {
        List<T> results = new ArrayList<T>();
        if (null != tasks && tasks.size() > 0) {
            List<Future> futures = new ArrayList<Future>();
            for (int i = 0; i < tasks.size(); i++) {
                Future future = executor.submit(tasks.get(i));
                futures.add(future);
            }
            for (Future future : futures) {
                try {
                    results.add((T) future.get(timeOut, TimeUnit.SECONDS));
                } catch (Exception e) {
                    logger.error("Execute task fail.", e);
                }
            }
        }
        return results;
    }

    public <T> List<String> startWithResult2(List<String> urls) {
        List<Future<String>> results = new ArrayList<Future<String>>();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < urls.size(); i++){
            String[] urlFileColum = urls.get(i).split("~");
            if (urlFileColum.length == 1) {
                Future<String> future = executor.submit(new ThreadClientFilter(urls.get(i), null,null));
                results.add(future);
            } else if (urlFileColum.length == 2) {
                Future<String> future = executor.submit(new ThreadClientFilter(urlFileColum[0], urlFileColum[1], null));
                results.add(future);
            } else if (urlFileColum.length == 3) {
                Future<String> future = executor.submit(new ThreadClientFilter(urlFileColum[0], urlFileColum[1], urlFileColum[2]));
                results.add(future);
            }
        }
        String resultData = null;
        for (Future<String> fs : results) {
            try {
                resultData = fs.get(timeOut, TimeUnit.SECONDS);
                if (resultData.indexOf("ROWKEY") > -1) {
                    resultData = resultData.replaceAll("ROWKEY", "_ID");
                }
            } catch (Exception e) {
                logger.error("远程获取数据异常" + fs, e);
                continue;
            }
        }
        return list;
    }

    public void destory() {
        executor.shutdown();
    }

    public IThreadPoolMonitorService getThreadPoolMonitorService() {
        return threadPoolMonitorService;
    }

    public void setThreadPoolMonitorService(IThreadPoolMonitorService threadPoolMonitorService) {
        this.threadPoolMonitorService = threadPoolMonitorService;
    }

    public IThreadPoolExecutorService getThreadPoolExecutorService() {
        return threadPoolExecutorService;
    }

    public void setThreadPoolExecutorService(IThreadPoolExecutorService threadPoolExecutorService) {
        this.threadPoolExecutorService = threadPoolExecutorService;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    class ThreadClientFilter extends AbstractTaskWithResult<String> {

        private String url;
        private String filterColum;
        private String fileColumTime;

        public ThreadClientFilter(String url, String filterColum, String fileColumTime) {
            this.url = url;
            this.filterColum = filterColum;
            this.fileColumTime = fileColumTime;
        }

        @Override
        public String task() {
            return null;
        }
    }

    /**
     * 批量启动线程
     * @param tasks
     * @param <T>
     * @return
     */
    public <T> ResultData<T> startTasks(List<AbstractTaskWithResult> tasks) {
        ResultData<T> result = new ResultData<>();
        if (null != tasks && tasks.size() > 0) {
            List<Future> futures = new ArrayList<Future>();
            for (int i = 0; i < tasks.size(); i++) {
                Future future = executor.submit(tasks.get(i));
                futures.add(future);
            }
            for (Future future : futures) {
                try {
                    ResultData<T> baseResult = (ResultData<T>) future.get(timeOut, TimeUnit.SECONDS);
                    if (null != baseResult && baseResult.getTotal() > 0) {
                        result.addTotal(baseResult.getTotal());
                        result.getData().addAll(baseResult.getData());
                    }
                } catch (Exception e) {
                    logger.error("Execute task fail.", e);
                }
            }
        }
        return result;
    }

    public <T> ResultData<T> startTasks2(List<AbstractTaskWithResult> tasks, Class<T> clazz) {
        ResultData<T> result = new ResultData<T>();
        Integer returnCount = 0;
        if (null != tasks && tasks.size() > 0) {
            List<Future> futures = new ArrayList<Future>();
            for (int i = 0; i< tasks.size(); i++) {
                Future future = executor.submit(tasks.get(i));
                futures.add(future);
            }
            for (Future future : futures) {
                ++ returnCount;
                try {
                    ResultData<T> baseResult = (ResultData<T>) future.get(timeOut, TimeUnit.SECONDS);
                    if (null != baseResult && CollectionUtils.isNotEmpty(baseResult.getData())) {
                        result.addTotal(baseResult.getTotal());
                        result.getData().addAll(baseResult.getData());
                    }
                } catch (Exception e) {
                    logger.error("Execute task fail.", e);
                }
            }
        }
        // 设置多线程查询结果总数
        result.setReturnCount(returnCount);
        return result;
    }

}
