package com.wkk.demo.algo.learn.sort;

import java.util.Arrays;

import static com.wkk.demo.algo.learn.sort.InsertionSort.generateArray;

/**
 * @Description 归并排序的代码实现
 * @Author Wangkunkun
 * @Date 2020/7/20 20:53
 */
public class MergeSort {

    public static void sort(int[] arrays) {
        mergeSort(arrays, 0, arrays.length -1);
    }

    public static void mergeSort(int[] arrays, int begin, int end) {
        if(begin >= end) {
            return;
        }
        int middle = (begin + end) / 2;
        mergeSort(arrays, begin, middle);
        mergeSort(arrays, middle + 1, end);
        merge1(arrays, begin, middle, middle + 1, end);
    }

    private static void merge(int[] arrays, int begin, int end, int nextBegin, int nextEnd) {
        int i = begin, j = nextBegin;
        int[] tempArrays = new int[(nextEnd - begin) + 1];
        int k = 0;
        while (i <= end && j <= nextEnd) {
            if(arrays[i] < arrays[j]) {
                tempArrays[k++] = arrays[i++];
            }else {
                tempArrays[k++] = arrays[j++];
            }
        }
        if(i <= end) {
            for (; i <= end ; i++) {
                tempArrays[k++] = arrays[i];
            }
        }
        if(j <= nextEnd) {
            for (; j <= end ; j++) {
                tempArrays[k++] = arrays[j];
            }
        }
        for (int l = 0; l < k; l++) {
            arrays[begin+l] = tempArrays[l];
        }
    }

    /**
     * 该实现有问题-已经修复但是需要更多验证
     * [10,6,4,7] 排序后为 [4, 6, 10, 7]
     * @param arrays
     * @param begin
     * @param end
     * @param nextBegin
     * @param nextEnd
     */
    private static void merge1(int[] arrays, int begin, int end, int nextBegin, int nextEnd) {
        int index = 0;
        for (int i = nextBegin; i <= nextEnd; i ++ ) {
            int tempIndex = i;
            int temp = arrays[tempIndex];
            index ++;
            for (int j = end + index; j >= begin ; j--) {
                if(arrays[j] > temp) {
                    arrays[tempIndex] =  arrays[j];
                    tempIndex = j;
                }
            }
            arrays[tempIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{8,3,2,5,9,1,7,4, 0,12,10};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
