package com.wkk.demo.algo.learn.sort;

import java.util.Arrays;

/**
 * @Description 计数排序的代码实现
 * @Author Wangkunkun
 * @Date 2020/8/1 22:22
 */
public class CountingSort {

    public static void sort(int[] arrays) {
        if(arrays.length <= 1) {
            return;
        }
        // 获取数组边界
        int min = arrays[0];
        int max = arrays[0];
        for (int array : arrays) {
            if(array > max) {
                max = array;
            }else if(array < min) {
                min = array;
            }
        }

        // 对数据进行计数
        int[] indexNum = new int[max - min + 1];
        for (int i = 0; i < arrays.length; i++) {
            indexNum[arrays[i] - min] ++;
        }

        // 对计数后的数据累加获得排名
        for (int i = 1; i < indexNum.length; i++) {
            indexNum[i] = indexNum[i] + indexNum[i - 1];
        }

        // 临时数组r，存储排序之后的结果
        int[] temp = new int[arrays.length];

        // 计算排序获取排序后数组
        for (int i = arrays.length - 1; i >= 0 ; i --) {
            int sortNum = indexNum[arrays[i] - min];
            temp[--sortNum] = arrays[i];
            indexNum[arrays[i] - min] = sortNum;
        }
        for (int i = 0; i < temp.length; i++) {
            arrays[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 3, 22, 5, 11, 41, 45, 26, 29, 10, 7, 8, 30, 27, 42, 43, 40, 46, 47, 46, 45, 47, -4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
