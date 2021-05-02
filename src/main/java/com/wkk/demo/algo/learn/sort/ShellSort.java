package com.wkk.demo.algo.learn.sort;

import java.util.Arrays;

import static com.wkk.demo.algo.learn.sort.InsertionSort.generateArray;

/**
 * @Description 希尔排序的代码实现
 * @Author Wangkunkun
 * @Date 2020/7/20 17:29
 */
public class ShellSort {

    /**
     * 希尔排序，按照希尔序列进行分组
     * @param arrays
     */
    public static void sort(int[] arrays) {
        if(arrays.length <= 1) {
            return;
        }
        int index = 0;
        int length = arrays.length;
        int gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int temp = arrays[i];
                int preIndex = i - gap;
                index ++;
                while (preIndex >= 0 && temp <  arrays[preIndex]) {
                    index ++;
                    arrays[i] = arrays[preIndex];
                    arrays[preIndex] = temp;
                    preIndex -= gap;
                }
            }
            gap = gap/2;
        }
        System.out.println("index : " + index);
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{8,3,2,5,9,1,7,4,0};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));

        /*int[][] arrayss = new int[100000][];
        for (int i = 0; i < 100000; i++) {
            int[] arr = generateArray(200, 200);
            arrayss[i] = arr;
        }
        long timeMillis = System.currentTimeMillis();
        for (int[] array : arrayss) {
            sort(array);
        }
        System.out.println("希尔排序用时：" + (System.currentTimeMillis() - timeMillis));*/
    }
}
