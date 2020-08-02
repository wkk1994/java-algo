package com.wkk.demo.algo.learn.sort;

import java.util.Arrays;

/**
 * @Description 桶排序的代码实现
 * @Author Wangkunkun
 * @Date 2020/8/1 21:12
 */
public class BucketSort {

    /**
     * 桶排序
     * @param arrays 排序数组
     * @param bucketSize 桶大小
     */
    public static void sort(int[] arrays, int bucketSize) {
        if(arrays.length <= 1) {
            return;
        }
        // 先确定数组边界
        int min = arrays[0];
        int max = arrays[0];
        for (int array : arrays) {
            if(array > max) {
                max = array;
            }else if(array < min) {
                min = array;
            }
        }
        // 通过数据边界，确定桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];

        // 将数据分配到对应的桶中
        for (int i = 0; i < arrays.length; i++) {
            int bucketIndex  = (arrays[i] - min) / bucketSize;
            if(buckets[bucketIndex].length == indexArr[bucketIndex]) {
                expansionArray(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arrays[i];
        }

        int k = 0;
        // 对每个桶进行排序后合并
        for (int i = 0; i < buckets.length; i++) {
            int[] bucket = buckets[i];
            if(bucket.length <= 0) {
                continue;
            }
            quickSort(bucket, 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                arrays[k++] = bucket[j];
            }
        }
    }

    /**
     * 数组扩容，扩容后是原来的2倍
     * @param buckets
     * @param bucketIndex
     */
    private static void expansionArray(int[][] buckets, int bucketIndex) {
        int[] temp = buckets[bucketIndex];
        buckets[bucketIndex] = new int[temp.length * 2];
        for (int i = 0; i < temp.length; i++) {
            buckets[bucketIndex][i] = temp[i];
        }
    }

    /**
     * 快速排序
     * @param array
     * @param begin
     * @param end
     */
    private static void quickSort(int[] array, int begin, int end) {
        if(begin >= end) {
            return;
        }
        // 获取分区点
        int partition = partition(array, begin, end);
        quickSort(array, begin, partition - 1);
        quickSort(array, partition + 1, end);
    }

    /**
     * 获取分区点，每次都是从数组末尾作为分区点
     * @param array
     * @param begin
     * @param end
     * @return
     */
    private static int partition(int[] array, int begin, int end) {
        int endNum = array[end];
        int partition = begin;
        for (int i = begin; i <= end; i++) {
            if(array[i] < endNum) {
                if(partition == i) {
                    partition ++;
                }else {
                    int temp = array[partition];
                    array[partition] = array[i];
                    array[i] = temp;
                    partition ++;
                }
            }
        }
        array[end] = array[partition];
        array[partition] = endNum;
        return partition;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 22, 5, 11, 41, 45, 26, 29, 10, 7, 8, 30, 27, 42, 43, 40, 46, 47, 46, 45, 47};
        sort(array, 5);
        System.out.println(Arrays.toString(array));
    }
}
