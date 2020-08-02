package com.wkk.demo.algo.learn.sort;

import java.util.Arrays;

/**
 * @Description 快速排序的代码实现
 * @Author Wangkunkun
 * @Date 2020/7/24 10:45
 */
public class QuickSort {

    public static void sort(int[] arrays) {
        quickSort(arrays, 0, arrays.length - 1);
    }

    private static void quickSort(int[] arrays, int begin, int end) {
        if(begin >= end) {
            return;
        }
        // 获取分区点
        int partition = partition1(arrays, begin, end);
        quickSort(arrays, begin, partition - 1);
        quickSort(arrays, partition + 1, end);
    }

    /**
     * 获取数组分区点并分区
     * 实现方式：默认最后一个元素为分区元素，从头遍历数组，设置一个变量始终指向分区点后的一个元素index，
     * 通过不断比较元素，移动index，最后index就是分区点
     * @param arrays
     * @param begin
     * @param end
     * @return
     */
    private static int partition(int[] arrays, int begin, int end){
        // 快速排序分区点
        int pivotIndex = end;
        int pivot = arrays[pivotIndex];
        int index = begin;
        for (int i = begin; i <= end - 1; i++) {
            if(arrays[i] < pivot) {
                if(index == i) {
                    index ++;
                }else {
                    int temp = arrays[index];
                    arrays[index] = arrays[i];
                    arrays[i] = temp;
                    index ++;
                }
            }
        }

        arrays[pivotIndex] = arrays[index];
        arrays[index] = pivot;
        return index;
    }

    /**
     * 取中间节点作为分区点
     * @param arrays
     * @param begin
     * @param end
     * @return
     */
    private static int partition1(int[] arrays, int begin, int end){
        // 快速排序分区点
        int pivotIndex = (begin + end)/2;
        int pivot = arrays[pivotIndex];
        int index = begin;
        // 将分区点放到数据放到末尾
        arrays[pivotIndex] = arrays[end];
        arrays[end] = pivot;
        pivotIndex = end;
        for (int i = begin; i <= end - 1; i++) {
            if(arrays[i] < pivot) {
                if(index == i) {
                    index ++;
                }else {
                    int temp = arrays[index];
                    arrays[index] = arrays[i];
                    arrays[i] = temp;
                    index ++;
                }
            }
        }

        arrays[pivotIndex] = arrays[index];
        arrays[index] = pivot;
        return index;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{3,5,7,3,1,5,8,4};
        sort(arrays);
        //partition1(arrays, 0, arrays.length -1);
        System.out.println(Arrays.toString(arrays));
    }
}
