package com.wkk.demo.algo.learn.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * @Description 通过堆实现获取中位数操作
 * 实现细节，通过维护两个堆，一个大顶堆，一个小顶堆。在数据插入时选择插入大顶堆或者小顶堆。并且一直保持大顶堆的数据个数是当前总数量的
 * 一半，这样大顶堆的堆顶就是中位数。
 * @Author Wangkunkun
 * @Date 2020/8/31 13:01
 */
public class MedianHeap<T extends Comparable> {

    private int size;

    /**
     * 小顶堆
     */
    private PriorityQueue<T> minQueue;

    /**
     * 大顶堆
     */
    private PriorityQueue<T> maxQueue;

    private class MaxComparator implements Comparator {

        @Override
        public int compare(Object o, Object t1) {
            Comparable comparableO = (Comparable) o;
            Comparable comparableT = (Comparable) t1;
            return comparableO.compareTo(comparableT);
        }
    }

    private class MinComparator implements Comparator {

        @Override
        public int compare(Object o, Object t1) {
            Comparable comparableO = (Comparable) o;
            Comparable comparableT = (Comparable) t1;
            int compare = comparableO.compareTo(comparableT);
            if(compare > 0) {
                return -1;
            }else if(compare < 0) {
                return 1;
            }
            return 0;
        }
    }
    public MedianHeap() {
        this.minQueue = new PriorityQueue<>(new MaxComparator());
        this.maxQueue = new PriorityQueue<>(new MinComparator());
    }

    /**
     * 添加数据，添加数据后需要根据两个堆数据的数量，调整两个堆数据数量
     * @param data
     */
    public void add(T data) {
        if(data == null) {
            throw new NullPointerException();
        }
        T peek = maxQueue.peek();
        if(peek == null || data.compareTo(peek) <= 0) {
            maxQueue.add(data);
        }else {
            minQueue.add(data);
        }
        this.size ++;
        // 调整堆数据的数量
        int mid = this.size % 2 == 0 ? this.size >>> 1 : (this.size >>> 1) + 1;
        if(maxQueue.size() == mid) {
            return;
        }else if(maxQueue.size() > mid) {
            T poll = maxQueue.poll();
            minQueue.add(poll);
        }else {
            T poll = minQueue.poll();
            maxQueue.add(poll);
        }
    }

    /**
     * 获取中位数，直接返回maxQueue的顶部
     * @return
     */
    public T getMid() {
        return maxQueue.peek();
    }

    public static void main(String[] args) {
        MedianHeap<Integer> medianHeap = new MedianHeap<>();
        medianHeap.add(1);
        medianHeap.add(2);
        medianHeap.add(3);
        System.out.println(medianHeap.getMid());
        medianHeap.add(1);
        System.out.println(medianHeap.getMid());
        medianHeap.add(89);
        medianHeap.add(60);
        medianHeap.add(50);
        medianHeap.add(90);
        medianHeap.add(100);
        System.out.println(medianHeap.getMid());
    }
}
