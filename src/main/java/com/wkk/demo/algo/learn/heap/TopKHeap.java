package com.wkk.demo.algo.learn.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description 利用堆求top K问题
 * 实现细节：对于求最大值的top K问题，通过维护一个大小为K的小顶堆，在添加数据时如果新加入的数据比堆顶数据大，则删除堆顶并加入新数据，否则
 * 不加入新数据。最后获得的堆就是top K的数据。
 * @Author Wangkunkun
 * @Date 2020/8/31 20:31
 */
public class TopKHeap<T extends Comparable> {

    private PriorityQueue<T> priorityQueue;

    private int length;

    public TopKHeap(int n) {
        this.length = n;
        priorityQueue = new PriorityQueue<T>(n);
    }

    public void add(T data) {
        T peek = priorityQueue.peek();
        if(peek == null) {
            priorityQueue.add(data);
            return;
        }
        if(this.length == priorityQueue.size() && data.compareTo(peek) > 0) {
            priorityQueue.poll();
            priorityQueue.add(data);
        }else if(this.length > priorityQueue.size()) {
            priorityQueue.add(data);
        }
    }

    public void printlnAll() {
        System.out.println(Arrays.toString(priorityQueue.toArray()));
    }

    public static void main(String[] args) {
        TopKHeap<Integer> topKHeap = new TopKHeap<>(5);
        topKHeap.add(17);
        topKHeap.add(18);
        topKHeap.add(21);
        topKHeap.add(11);
        topKHeap.add(4);
        topKHeap.add(7);
        topKHeap.add(90);
        topKHeap.add(15);
        topKHeap.add(11);
        topKHeap.add(10);
        topKHeap.add(6);
        topKHeap.add(1);
        topKHeap.printlnAll();
    }
}
