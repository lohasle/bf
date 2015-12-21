package org.lohas.bf.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lohas on 2015/6/27.
 * https://github.com/lohasle
 */
public class TimerUtilsTest {

    public void test1() throws ParseException {
        Timer timer = new Timer();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = dateFormatter.parse("2015/6/17 15:21:30");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("我是任务  "

                        + " 被执行了，执行时间为 " + new Date(this.scheduledExecutionTime()));
                this.cancel();
            }

            @Override
            public boolean cancel() {
                System.out.println("我是任务 "

                        + " 被取消了，取消时间为 " + new Date());
                return super.cancel();
            }
        }, date);
    }


    public void test2() throws InterruptedException {
        lanuchTimer();
        Thread.sleep(1000 * 5);//5秒钟之后添加一个新任务
        addOneTask();
    }

    public static void main(String[] args) throws Exception {
        TimerUtilsTest timerUtilsTest = new TimerUtilsTest();
//        timerUtilsTest.test1();
        timerUtilsTest.test2();

    }


    /*
        private Timer timer = new Timer();
    */
    //启动计时器
    public void lanuchTimer() {
        new Timer().schedule(new TimerTask() {
            public void run() {
                throw new RuntimeException();
            }
        }, 1000 * 3, 500);
    }

    //向计时器添加一个任务
    public void addOneTask() {
        new Timer().schedule(new TimerTask() {
            public void run() {
                System.out.println("hello world");
            }
        }, 1000 * 1, 1000 * 5);
    }
}
