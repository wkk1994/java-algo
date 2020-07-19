package com.wkk.demo.algo.learn.queue;

/**
 * @Description 数组实现的队列
 * @Author Wangkunkun
 * @Date 2020/7/18 22:24
 */
public class ArrayQueue {

    // 数组
    private String[] items;

    private int n = 0;

    private int head;

    private int tail;

    public ArrayQueue(int n) {
        items = new String[n];
        this.n = n;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if(tail == n) {
            // 队列已满
            if(head == 0) {
                return false;
            }
            // 数据搬移
            for (int i = head; i < tail; i ++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail ++;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        if(head == tail) {
            return null;
        }
        String item = items[head];
        items[head ++] = null;
        return item;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        arrayQueue.enqueue("5");
        System.out.println(arrayQueue.enqueue("6"));
        System.out.println(arrayQueue.enqueue("7"));
        System.out.println(arrayQueue.enqueue("8"));
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.enqueue("9"));
        System.out.println(arrayQueue.enqueue("10"));
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
    }
}
