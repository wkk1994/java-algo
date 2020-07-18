package com.wkk.demo.algo.learn.stack;

import java.util.Arrays;

/**
 * @Description 使用数组实现的栈结构
 * @Author Wangkunkun
 * @Date 2020/7/18 20:16
 */
public class ArrayStack {

    /**
     * 栈中元素个数
     */
    private int size;

    /**
     * 数组长度
     */
    private int length;

    /**
     * 数组
     */
    private String[] items;

    public ArrayStack(int n) {
        items = new String[n];
        this.length = n;
        this.size = 0;
    }

    /**
     * 入栈操作
     * @param item
     * @return
     */
    public boolean push(String item) {
        if(size == length) {
            // 数组空间不够，需要扩展
            grow();
        }
        items[size] = item;
        size ++;
        return true;
    }

    /**
     * 出栈操作
     * @return
     */
    public String pop() {
        if(size == 0){
            return null;
        }
        String item = items[size - 1];
        size--;
        return item;
    }

    private void grow() {
        length = 2 * (size + 1);
        items = Arrays.copyOf(items, length);
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
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
