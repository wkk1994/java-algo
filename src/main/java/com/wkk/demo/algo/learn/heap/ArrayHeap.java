package com.wkk.demo.algo.learn.heap;


import java.util.Arrays;

/**
 * @Description 堆的数组实现
 * @Author Wangkunkun
 * @Date 2020/8/16 13:15
 */
public class ArrayHeap {

    /**
     * 数据
     */
    private int[] array;

    /**
     * 已存放数量
     */
    private int count;

    /**
     * 最大存放数据量
     */
    private int length;

    public ArrayHeap(int length) {
        this.array = new int[length];
        this.length = length;
    }

    /**
     * 插入数据
     * @param value
     */
    public void insert(int value) {
        if(count >= length) {
            return;
        }
        ++count;
        array[count] = value;
        int i = count;
        // 自下往上堆化
        while (i/2 > 0 && array[i] > array[i/2]) {
            int temp = array[i / 2];
            array[i / 2] = array[i];
            array[i] = temp;
            i = i / 2;
        }
    }

    /**
     * 删除最大值
     * @return
     */
    public int removeMax() {
        int value = array[1];
        array[1] = array[count];
        array[count] = 0;
        count -- ;
        int i = 1;
        int maxPos = i;
        while (true) {
            if(i * 2 <= count && array[2 * i] > array[maxPos]) {
                maxPos = 2 * i;
            }
            if(i * 2 <= count && array[2 * i + 1] > array[maxPos]) {
                maxPos = 2 * i + 1;
            }
            if(maxPos == i) {
                break;
            }
            int temp = array[maxPos];
            array[maxPos] = array[i];
            array[i] = temp;
            i = maxPos;
        }
        return value;
    }

    public static void buildHeap(int[] array, int n) {
        for (int i = n/2; i >= 1; i--) {
            int index = i;
            int maxPos = i;
            while (true) {
                if(index * 2 <= n && array[index * 2] > array[maxPos]) {
                    maxPos = index * 2;
                }
                if(index * 2 <= n - 1 && array[index * 2 + 1] > array[maxPos]) {
                    maxPos = index * 2 + 1;
                }
                if(index == maxPos) {
                    break;
                }
                int temp = array[maxPos];
                array[maxPos] = array[index];
                array[index] = temp;
                index = maxPos;
            }
        }
    }

    /**
     * 建堆之后的排序操作
     * @param array
     * @param n
     */
    public static void sort(int[] array, int n) {
        int index = n;
        while (index > 1) {
            int temp = array[1];
            array[1] = array[index];
            array[index--] = temp;
            int maxPos = 1;
            int i = 1;
            while (true) {
                if(2 * i <= index && array[2 * i] > array[maxPos]) {
                    maxPos = 2 * i;
                }
                if(2 * i + 1 <= index && array[2 * i + 1] > array[maxPos]) {
                    maxPos = 2 * i + 1;
                }
                if(maxPos == i) {
                    break;
                }
                temp = array[maxPos];
                array[maxPos] = array[i];
                array[i] = temp;
                i = maxPos;
            }
        }
    }

    public static void main(String[] args) {
        ArrayHeap arrayHeap = new ArrayHeap(10);
        arrayHeap.insert(1);
        arrayHeap.insert(5);
        arrayHeap.insert(8);
        arrayHeap.insert(10);
        arrayHeap.insert(3);
        System.out.println(Arrays.toString(arrayHeap.array));
        System.out.println(arrayHeap.removeMax());
        System.out.println(Arrays.toString(arrayHeap.array));
        int[] arrays = new int[]{0, 7, 5, 19, 8, 4, 1, 20, 13, 16};
        ArrayHeap.buildHeap(arrays, arrays.length -1);
        System.out.println(Arrays.toString(arrays));
        ArrayHeap.sort(arrays, arrays.length -1);
        System.out.println(Arrays.toString(arrays));
    }


}
