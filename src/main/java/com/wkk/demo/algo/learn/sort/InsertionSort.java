package com.wkk.demo.algo.learn.sort;


/**
 * @Description 插入排序的代码实现
 * @Author Wangkunkun
 * @Date 2020/7/19 15:42
 */
public class InsertionSort {

    /**
     * 插入排序，每次插入时从头开始遍历已排序数据
     * @param array
     */
    public static void sortFromHead(int[] array) {
        if(array.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            for (int j = 0; j < i; j++) {
                index ++;
                if(value < array[j]) {
                    int temp = array[j];
                    array[j] = value;
                    value = temp;
                }
            }
            array[i] = value;
        }
        System.out.println(index);
    }

    /**
     * 插入排序，每次插入时从尾开始遍历已排序数据。这样对于有序数组只需要O(N)的时间复杂度
     * @param array
     */
    public static void sortFromTail(int[] array) {
        if(array.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                index ++;
                if(value < array[j]) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = value;
        }
        System.out.println(index);
    }

    public static void main(String[] args) {
        /*int[] arrays = new int[]{1, 3, 4, 5, 6, 7, 8, 9};
        sortFromHead(arrays);
        System.out.println(Arrays.toString(arrays));
        int[] arrays1 = new int[]{1, 3, 4, 5, 6, 7, 8, 9};
        sortFromTail(arrays1);
        System.out.println(Arrays.toString(arrays1));*/
        int[][] arrays = new int[100000][];
        for (int i = 0; i < 100000; i++) {
            int[] arr = generateArray(200, 200);
            arrays[i] = arr;
        }
        long timeMillis = System.currentTimeMillis();
        for (int[] array : arrays) {
            sortFromTail(array);
        }
        System.out.println("插入排序用时：" + (System.currentTimeMillis() - timeMillis));

        /*long timeMillis = System.currentTimeMillis();
        for (int[] array : arrays) {
            BubbleSort.sort(array);
        }
        System.out.println("冒泡排序用时：" + (System.currentTimeMillis() - timeMillis));*/


    }

    public static int[] generateArray(int len, int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }
}
