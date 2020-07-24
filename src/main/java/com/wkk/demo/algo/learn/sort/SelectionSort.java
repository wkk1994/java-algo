package com.wkk.demo.algo.learn.sort;

import java.util.Arrays;

/**
 * @Description 选择排序的代码实现
 * @Author Wangkunkun
 * @Date 2020/7/19 16:12
 */
public class SelectionSort {

    /**
     * 选择排序的代码实现
     * @param arrays
     */
    public static void sort(int[] arrays) {
        if(arrays.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < arrays.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrays.length; j++) {
                index ++;
                if(arrays[j] < arrays[min]) {
                    min = j;
                }
            }
            int temp = arrays[i];
            arrays[i] = arrays[min];
            arrays[min] = temp;
        }
        System.out.println(index);
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1, 3, 4, 5, 6, 7, 8, 9};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
        arrays = new int[]{8,3,2,5,9,1,7,4};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
