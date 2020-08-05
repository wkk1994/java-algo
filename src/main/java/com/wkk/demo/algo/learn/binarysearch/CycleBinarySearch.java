package com.wkk.demo.algo.learn.binarysearch;

/**
 * @Description 循环数组二分查找
 * @Author Wangkunkun
 * @Date 2020/8/2 15:05
 */
public class CycleBinarySearch {

    /**
     * 在数组中二分查找指定值
     * 实现方式是：通过二分查找先确定数组的循环点，将数组分为2个有序数组，然后确定目标数据在哪个数组，对哪个数组进行二分查找
     * @param arrays
     * @param target
     * @return
     */
    public static int bSearch(int[] arrays, int target) {
        // 二分法确定数组循环点
        int min = 0, max = arrays.length - 1;
        int mid = max >> 1;
        while (mid > 0 && arrays[mid] > arrays[mid - 1]) {
            if(arrays[mid] < arrays[min]) {
                max = mid - 1;
            }else if(arrays[max] < arrays[mid]) {
                min = mid + 1;
            }else {
                mid = 0;
                break;
            }
            mid = min + ((max - min) >> 1);
        }
        System.out.println("mid: " + mid);
        if(mid != 0) {
            if(arrays[0] < target) {
                min = 0;
                max = mid - 1;
            }else  if(arrays[0] > target) {
                min = mid;
                max = arrays.length - 1;
            } else {
                return 0;
            }
        }else {
            min = 0;
            max = arrays.length - 1;
        }

        while (min <= max) {
            mid = min + ((max - min) >> 1);
            if(arrays[mid] > target) {
                max = mid - 1;
            }else if(arrays[mid] < target) {
                min = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,3,5,6,7,9,12,23,25,27};
        System.out.println(bSearch(arrays, 9));
        System.out.println(bSearch(arrays, 9));
        System.out.println(bSearch(arrays, 4));
        System.out.println(bSearch(arrays, 48));
        arrays = new int[]{7,9,12,23,25,27, 1,3,5,6};
        System.out.println("------------------");
        System.out.println(bSearch(arrays, 9));
        System.out.println(bSearch(arrays, 9));
        System.out.println(bSearch(arrays, 4));
        System.out.println(bSearch(arrays, 48));
        System.out.println(bSearch(arrays, 1));
        System.out.println(bSearch(arrays, 6));
        System.out.println(bSearch(arrays, 27));
    }
}
