package org.lohas.bf.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * Created by lohas on 2015/6/27.
 * https://github.com/lohasle
 * 定时执行模板
 */
public abstract class SimpleTimeTask extends TimerTask {

    private Logger logger = LoggerFactory.getLogger(SimpleTimeTask.class);



    /**
     * 定时器处理之前的动作 为 true 才会执行
     * @return
     */
    public abstract boolean before();

    /**
     * 定时器处理之后的动作
     * @return
     */
    public abstract void after();


    /**
     * 执行task 任务
     */
    public abstract void execTask();

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        if(before()){
            // true
            execTask();
        }
        after();
    }
}
