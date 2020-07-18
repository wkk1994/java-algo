package com.wkk.demo.algo.learn.linked;

/**
 * @Description 简单链表实现
 * @Author Wangkunkun
 * @Date 2020/7/4 17:04
 */
public class LinkedList<T> {

    int size = 0;

    public class LinkedListNode<T> {

        public T value;

        public LinkedListNode prev;

        public LinkedListNode next;

        LinkedListNode(LinkedListNode<T> prev, T value, LinkedListNode<T> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

    public LinkedListNode<T> head;

    public LinkedListNode<T> tail;

    public boolean add(T e) {
        linkLast(e);
        return true;
    }

    public int size() {
        return size;
    }

    /**
     * Links e as last element.
     */
    void linkLast(T e) {
        final LinkedListNode<T> l = tail;
        final LinkedListNode<T> newNode = new LinkedListNode<T>(l, e, null);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size ++;
    }

}
