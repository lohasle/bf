package org.lohas.bf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Created by lohas on 2015/7/13.
 * https://github.com/lohasle
 * 线程执行类
 * 缓存线程池
 */
public class ThreadPollExecutor {

    private static Logger logger = LoggerFactory.getLogger(ThreadPollExecutor.class);

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static Future exeThread(Callable runnable) {
        logger.debug("execute ThreadPollExecutor Callable");
        return executor.submit(runnable);
    }

    public static void exeThread(Runnable runnable) {
        logger.debug("execute ThreadPollExecutor Runnable");
        executor.submit(runnable);
    }


    // test
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("begin");

        //1
        Future future = exeThread(new Callable() {
            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public Boolean call() throws Exception {
                System.out.println("1");
                Thread.sleep(1000);
                return true;
            }
        });
        //2
        Boolean boo = (Boolean) future.get(); //得到异步结果
        if (boo) {
            Future future1 = exeThread(new Callable() {
                /**
                 * Computes a result, or throws an exception if unable to do so.
                 *
                 * @return computed result
                 * @throws Exception if unable to compute a result
                 */
                @Override
                public Boolean call() throws Exception {
                    Thread.sleep(1000);
                    System.out.println("2");
                    throw new Exception();
                }
            });

            // 3
            Boolean boo1 = (Boolean) future1.get();
            if (boo1) {
                System.out.println("over");
            }
        }
    }
}
