package com.wkk.demo.algo.learn.queue;

/**
 * @Description 循环队列的代码实现
 * @Author Wangkunkun
 * @Date 2020/7/19 13:48
 */
public class CircularQueue {

    private String[] items;

    private int n;

    private int head;

    private int tail;

    public CircularQueue(int n) {
        items = new String[n];
        this.n = n;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // 队列已满
        if((tail +1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        // 队列为空
        if(tail == head) {
            return null;
        }
        String item = items[head];
        head = (head + 1) % n;
        return item;
    }

    public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void main(String[] args) {

        CircularQueue arrayQueue = new CircularQueue(5);
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
        System.out.println(climbStairs(45));
    }
}
