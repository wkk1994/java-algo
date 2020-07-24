package com.wkk.demo.algo.learn.sort;

import java.util.Arrays;

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
        merge(arrays, begin, middle, middle + 1, end);
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

    private static void merge1(int[] arrays, int begin, int end, int nextBegin, int nextEnd) {
        for (int i = nextBegin; i <= nextEnd; i ++ ) {
            int tempIndex = i;
            int temp = arrays[tempIndex];
            for (int j = end; j >= begin ; j--) {
                if(arrays[j] > temp) {
                    arrays[tempIndex] =  arrays[j];
                    tempIndex = j;
                }
            }
            arrays[tempIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{8,3,2,5,9,1,7,4};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
