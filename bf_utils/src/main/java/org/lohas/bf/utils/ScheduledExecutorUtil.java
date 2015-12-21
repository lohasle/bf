package org.lohas.bf.utils;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lohas on 2015/6/17.
 * https://github.com/lohasle
 * 定时类(延时执行)工具
 */
public class ScheduledExecutorUtil {

    /**
     * 初始化一个定时线程池
     */
    private static ScheduledExecutorService scheduExec = Executors.newScheduledThreadPool(4);


    private static Logger logger = LoggerFactory.getLogger(ScheduledExecutorUtil.class);

    /**
     * 指定时间执行定时任务
     *
     * @param timerTask
     * @param triggerTime
     */
    public static void schedule(Runnable timerTask, Date triggerTime) {
        if( triggerTime.getTime() - new Date().getTime()>=0){
            logger.info("开启一个定时任务，执行时间-->" + DateParser.format(triggerTime, "yyyy-MM-dd HH:mm:ss"));
            scheduExec.schedule(timerTask, triggerTime.getTime() - new Date().getTime(), TimeUnit.MILLISECONDS);
        }
    }


    // test
    public static void main(String[] args) throws ParseException {
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSS");

        Date date = new Date();
        for (int i =0;i<100;i++){
            final int finalI = i;
            final Date  date1 = DateUtils.addMilliseconds(date, i * 100);
            schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(dateFormatter.format(date1)+":执行任务"+finalI);
                    if(finalI%3==0){
                        try {
                            throw new Exception(finalI+"失败");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            },date1);
        }
    }
}
