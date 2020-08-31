package com.wkk.demo.algo.learn.heap;

import java.util.Arrays;

/**
 * @Description 使用堆实现优先级队列（大顶堆）
 * @Author Wangkunkun
 * @Date 2020/8/25 13:01
 */
public class PriorityQueue<T extends Comparable> {

    /**
     * 队列总长度
     */
    private int length;

    /**
     * 队列已使用长度
     */
    public int size = 0;

    private Object[] queue;

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    public PriorityQueue() {
        this.queue = new Object[DEFAULT_INITIAL_CAPACITY];
        this.length = DEFAULT_INITIAL_CAPACITY;
    }

    /**
     * 添加元素
     * @param data
     */
    public void add(T data) {
        if(data == null) {
            throw new NullPointerException();
        }
        if(this.size >= this.length) {
            // 数组扩容
            grow(this.size +1);
        }
        if(this.size == 0) {
            queue[this.size++] = data;
            return;
        }
        // 插入数据
        int k = this.size;
        while (k > 0) {
            int parent = k - 1 >>> 1;
            if(data.compareTo(queue[parent]) <= 0) {
                break;
            }
            queue[k] = queue[parent];
            k = parent;
        }
        this.size ++;
        queue[k] = data;
    }

    /**
     * 数组扩容，当前长度小于128时扩容原来的2倍，否则扩容原来+4
     * @param minCapacity 扩容要求的最小长度
     */
    private void grow(int minCapacity) {
        if(minCapacity <= -1) {
            throw new OutOfMemoryError();
        }
        if(minCapacity >= 128) {
            minCapacity = minCapacity > 2147483643 ? Integer.MAX_VALUE:minCapacity + 4;
        }else {
            minCapacity = minCapacity << 1;
        }
        this.length = minCapacity;
        queue = Arrays.copyOf(queue, minCapacity);

    }

    /**
     * 删除并返回最大值
     */
    public T poll() {
        if(this.size == 0) {
            return null;
        }
        Object result = queue[0];
        T data = (T) queue[--this.size];
        queue[0] = data;
        queue[this.size] = null;
        if(this.size <= 0) {
            return (T) result;
        }
        // 向下堆化
        int k = 0;
        while(k < this.size) {
            int left = (k << 1) + 1;
            int right = (k << 1) + 2;
            int temp = k;
            if(left < this.size && data.compareTo(queue[left]) < 0) {
                queue[temp] = queue[left];
                temp = left;
            }
            if(right < this.size && data.compareTo(queue[right]) < 0) {
                queue[temp] = queue[right];
                temp = right;
            }
            if(temp == k) {
                System.out.println("temp: " + temp);
                break;
            }
            k = temp;
        }
        queue[k] = data;
        return (T) result;
    }

    public T peek() {
        return (T) this.queue[0];
    }

    public static void main(String[] args) {
        System.out.println(2 << 1);
        System.out.println(3 << 1);
        System.out.println(Integer.MAX_VALUE + 1);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(5);
        priorityQueue.add(7);
        priorityQueue.add(7);
        priorityQueue.add(8);
        priorityQueue.add(8);
        priorityQueue.add(8);
        priorityQueue.add(8);
        priorityQueue.add(8);
        priorityQueue.add(8);
        priorityQueue.add(8);
        priorityQueue.add(8);
        priorityQueue.add(8);
        System.out.println(priorityQueue.poll());
        System.out.println(Arrays.toString(priorityQueue.queue));
        System.out.println(priorityQueue.poll());
        System.out.println(Arrays.toString(priorityQueue.queue));
        System.out.println(priorityQueue.poll());
        System.out.println(Arrays.toString(priorityQueue.queue));
    }
}
