package com.wkk.demo.algo.learn.heap.pojo;

/**
 * @Description 定时器信息
 * @Author Wangkunkun
 * @Date 2020/8/31 21:34
 */
public class ScheduleInfo implements Comparable {

    private long triggerTime;

    private Runnable runnable;

    public ScheduleInfo(long triggerTime, Runnable runnable) {
        this.triggerTime = triggerTime;
        this.runnable = runnable;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public long getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(long triggerTime) {
        this.triggerTime = triggerTime;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }
}
