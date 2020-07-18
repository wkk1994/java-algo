package com.wkk.demo.algo.learn.stack;

import java.util.LinkedList;

/**
 * @Description 使用链表实现的栈结构
 * @Author Wangkunkun
 * @Date 2020/7/18 20:16
 */
public class LinkedStack {

    /**
     * 链表
     */
    private LinkedList<String> items;

    public LinkedStack() {
        items = new LinkedList<>();
    }

    /**
     * 入栈操作
     * @param item
     * @return
     */
    public boolean push(String item) {
        return items.add(item);

    }

    /**
     * 出栈操作
     * @return
     */
    public String pop() {
        if(items == null || items.size() == 0) {
            return null;
        }
        return items.removeLast();
    }

    public static void main(String[] args) {
        LinkedStack arrayStack = new LinkedStack();
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");
        arrayStack.push("6");
        arrayStack.push("7");
        arrayStack.push("8");
        arrayStack.push("9");
        arrayStack.push("10");
        arrayStack.push("11");
        arrayStack.push("12");
        arrayStack.push("13");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}
