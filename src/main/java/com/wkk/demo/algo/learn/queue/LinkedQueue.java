package com.wkk.demo.algo.learn.queue;

import com.wkk.demo.algo.learn.linked.LinkedList;

/**
 * @Description 使用链表实现的队列
 * @Author Wangkunkun
 * @Date 2020/7/18 23:10
 */
public class LinkedQueue {

    // 数组
    private LinkedList<String> items;

    private int head;

    private int tail;

    public LinkedQueue() {
        items = new LinkedList<>();
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        return items.add(item);
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        if(items == null || items.head == null) {
            return null;
        }
        String value = items.head.value;
        items.head = items.head.next;
        return value;
    }

    public static void main(String[] args) {
        LinkedQueue arrayQueue = new LinkedQueue();
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
