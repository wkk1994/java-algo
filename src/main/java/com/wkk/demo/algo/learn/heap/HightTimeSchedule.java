package com.wkk.demo.algo.learn.heap;


import com.wkk.demo.algo.learn.heap.pojo.ScheduleInfo;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description 使用堆实现一个高性能的定时器 K问题
 * 实现细节：将定时器按照执行时间的先后顺序放到小顶堆里，每次循环获取堆顶定时器，根据当前定时器的触发时间，进行sleep，
 * 在指定时间后执行该定时器，继续下循环。
 * @Author Wangkunkun
 * @Date 2020/8/31 21:28
 */
public class HightTimeSchedule {

    //private Long
    private PriorityBlockingQueue<ScheduleInfo> priorityQueue;

    private Comparator<ScheduleInfo> comparator = new Comparator<ScheduleInfo>() {

        @Override
        public int compare(ScheduleInfo t1, ScheduleInfo t2) {
            if(t1.getTriggerTime() > t2.getTriggerTime()) {
                return  -1;
            }else if(t1.getTriggerTime() < t2.getTriggerTime()) {
                return 1;
            }else {
                return 0;
            }
        }
    };

    public HightTimeSchedule() {
        priorityQueue = new PriorityBlockingQueue<ScheduleInfo>(11, comparator);
    }


    /**
     * 添加定时器
     * @param timer
     * @param runnable
     */
    public void addDelayRun(long timer, Runnable runnable) {
        priorityQueue.add(new ScheduleInfo(timer, runnable));
    }

    public void run() {
        while (true) {
            ScheduleInfo scheduleInfo = null;
            try {
                // 获取要执行的定时器，等待5s。
                scheduleInfo = priorityQueue.poll(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(scheduleInfo == null || scheduleInfo.getRunnable() == null) {
                continue;
            }
            long timeMillis = System.currentTimeMillis();
            long runTime = scheduleInfo.getTriggerTime() - timeMillis;
            if(runTime > 0) {
                try {
                    Thread.sleep(runTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            scheduleInfo.getRunnable().run();
        }
    }
}
