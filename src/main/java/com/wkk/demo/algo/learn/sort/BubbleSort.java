package com.wkk.demo.algo.learn.sort;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 * @Author Wangkunkun
 * @Date 2020/7/19 15:19
 */
public class BubbleSort {

    public static void sort(int[] arrays) {
        if(arrays.length <= 1) {
            return;
        }
        boolean flag = false;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if(arrays[j] > arrays[j+1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                    flag = true;
                }
            }
            // 没有数据交换退出
            if(!flag) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{9,8,7,6,5,4,3,1};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
