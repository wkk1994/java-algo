package com.wkk.demo.algo.learn.binarysearch;

/**
 * @Description 二分查找的代码实现
 * @Author Wangkunkun
 * @Date 2020/7/25 17:02
 */
public class BinarySearch {

    /**
     * 二分查找，非递归实现
     * @param arrays
     * @param target
     * @return
     */
    public static int bSearch(int[] arrays, int target) {
        if(arrays.length <= 0) {
            return - 1;
        }
        int low = 0;
        int high = arrays.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if(arrays[mid] < target) {
                low = mid + 1;
            }else if(arrays[mid] > target) {
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找的递归实现
     * @param arrays
     * @param target
     * @return
     */
    public static int bSearchByRecursion(int[] arrays, int target) {
            return bSearchByRecursion(arrays, target,0, arrays.length -1);
    }

    public static int bSearchByRecursion(int[] arrays, int target, int begin, int end) {
        if(begin > end) {
            return -1;
        }
        int mid = begin + ((end - begin) >> 1);
        if(arrays[mid] < target) {
            return bSearchByRecursion(arrays, target, mid + 1, end);
        }else if(arrays[mid] > target) {
            return bSearchByRecursion(arrays, target, begin, mid  - 1);
        }else {
            return mid;
        }
    }

    /**
     * “求一个数的平方根”，要求精确到小数点后 6 位。
     * @param number
     * @return
     */
    /*public static int sqrt(int number) {

        Math.sqrt()
    }*/

    /**
     * 查找第一个等于给定值的元素
     * @param array
     * @param target
     * @return
     */
    public static int findFirstEqual(int[] array, int target) {
        int begin = 0, end = array.length - 1;
        int mid = 0;
        while (begin <= end) {
            mid = begin + ((end - begin) >> 1);
            if(array[mid] < target) {
                begin = mid + 1;
            }else if(array[mid] > target) {
                end = mid - 1;
            }else {
                if(mid == 0 || array[mid - 1] != target) {
                    return mid;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个等于给定值的元素
     * 实现方式二，饶脑的实现
     * @param array
     * @param target
     * @return
     */
    public static int findFirstEqual1(int[] array, int target) {
        int begin = 0, end = array.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] >= target) {
                end = mid  - 1;
            }else {
                begin = mid + 1;
            }
        }
        if(begin < array.length -1 && array[begin] == target) {
            return begin;
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param array
     * @param target
     * @return
     */
    public static int findLastEqual(int[] array, int target) {
        int begin = 0, end = array.length;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] > target) {
                end = mid - 1;
            }else if(array[mid] < target) {
                begin = mid + 1;
            }else {
                if(mid == array.length -1 || array[mid + 1] != target) {
                    return mid;
                }
                begin = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * 实现方式二：饶脑
     * @param array
     * @param target
     * @return
     */
    public static int findLastEqual1(int[] array, int target) {
        int begin = 0, end = array.length;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] <= target) {
                begin = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if(end != -1 && array[end] == target) {
            return end;
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param array
     * @param target
     * @return
     */
    public static int findFirstGT(int[] array, int target) {
        int begin = 0, end = array.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] < target ) {
                begin = mid + 1;
            }else {
                if(mid == 0 || array[mid - 1] < target) {
                    return mid;
                }
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * 实现方式二：饶脑
     * @param array
     * @param target
     * @return
     */
    public static int findFirstGT1(int[] array, int target) {
        int begin = 0, end = array.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] < target ) {
                begin = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if(begin < array.length && array[begin] >= target) {
            return begin;
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param array
     * @param target
     * @return
     */
    public static int findLastLT(int[] array, int target) {
        int begin = 0, end = array.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] > target ) {
                end = mid - 1;
            }else {
                if(mid == array.length - 1 || array[mid + 1] > target) {
                    return mid;
                }
                begin = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * 实现方式二：饶脑
     * @param array
     * @param target
     * @return
     */
    public static int findLastLT1(int[] array, int target) {
        int begin = 0, end = array.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] > target ) {
                end = mid - 1;
            }else {
                begin = mid + 1;
            }
        }
        if(end != -1 && array[end] <= target) {
            return end;
        }
        return -1;
    }


    /**
     * 二分法，计算一个数的平方跟，精确到指定位数
     * 对于平方跟可以除尽的数计算会有问题
     * @param num
     * @param digits
     * @return
     */
    public static double sqrt(double num, int digits) {
        double min = 0, max = num;
        double accuracy = 1;
        double stride = 1;
        for (int i = 0; i < digits; i++) {
            accuracy = accuracy * 0.1;
            stride = stride * 0.1;
        }
        stride = stride * 0.1;
        System.out.println(accuracy);
        System.out.println(stride);
        if(num < 1) {
            min = num;
            max = 1;
        }else if(num == 1) {
            return 1;
        }else {
            min = 1;
            max = (double)num / 2;
        }
        boolean flag = false;
        while (min < max) {
            System.out.println(" min : " + min);
            System.out.println(" max : " + max);
            if(flag) {
                return max;
            }
            if(max - min <= accuracy) {
                flag = true;
            }
            double mid = min + ((max - min) / 2);
            if(mid * mid < num) {
                min = mid + stride;
            }else if(mid * mid > num) {
                max = mid - stride;
            }else {
                return mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(0.01, 7));
    }
    /*public static void main(String[] args) {
        int[] arrays = new int[]{1,3,5,6,7,9,12,23,25,27};
        System.out.println(bSearch(arrays, 9));
        System.out.println(bSearchByRecursion(arrays, 9));
        System.out.println(bSearchByRecursion(arrays, 4));
        System.out.println(bSearchByRecursion(arrays, 48));

        arrays = new int[]{1,3,5,6,6,6,12,12,25,27};
        System.out.println(findFirstEqual(arrays, 6));
        System.out.println(findFirstEqual(arrays, 6));
        System.out.println(findFirstEqual(arrays, 4));
        System.out.println(findFirstEqual(arrays, 12));
        arrays = new int[]{1,3,5,6,6,6,12,12,25,27};
        System.out.println(findFirstEqual1(arrays, 6));
        System.out.println(findFirstEqual1(arrays, 6));
        System.out.println(findFirstEqual1(arrays, 4));
        System.out.println(findFirstEqual1(arrays, 12));

        arrays = new int[]{1,1,3,5,6,6,6,12,12,25,25};
        System.out.println(findLastEqual(arrays, 1));
        System.out.println(findLastEqual(arrays, 4));
        System.out.println(findLastEqual(arrays, 6));
        System.out.println(findLastEqual(arrays, 6));
        System.out.println(findLastEqual(arrays, 12));
        System.out.println(findLastEqual(arrays, 25));
        arrays = new int[]{1,1,3,5,6,6,6,12,12,25,25};
        System.out.println(findLastEqual(arrays, 1));
        System.out.println(findLastEqual(arrays, 4));
        System.out.println(findLastEqual(arrays, 6));
        System.out.println(findLastEqual(arrays, 6));
        System.out.println(findLastEqual(arrays, 12));
        System.out.println(findLastEqual(arrays, 25));

        System.out.println("----------");
        arrays = new int[]{1,1,3,5,6,6,6,12,12,25,25};
        System.out.println(findFirstGT(arrays, 0));
        System.out.println(findFirstGT(arrays, 1));
        System.out.println(findFirstGT(arrays, 4));
        System.out.println(findFirstGT(arrays, 6));
        System.out.println(findFirstGT(arrays, 13));
        System.out.println(findFirstGT(arrays, 12));
        System.out.println(findFirstGT(arrays, 26));

        System.out.println("----------");
        arrays = new int[]{1,1,3,5,6,6,6,12,12,25,25};
        System.out.println(findFirstGT1(arrays, 0));
        System.out.println(findFirstGT1(arrays, 1));
        System.out.println(findFirstGT1(arrays, 4));
        System.out.println(findFirstGT1(arrays, 6));
        System.out.println(findFirstGT1(arrays, 13));
        System.out.println(findFirstGT1(arrays, 12));
        System.out.println(findFirstGT1(arrays, 26));

        System.out.println("----------");
        arrays = new int[]{1,1,3,5,6,6,6,12,12,25,25};
        System.out.println(findLastLT(arrays, 0));
        System.out.println(findLastLT(arrays, 1));
        System.out.println(findLastLT(arrays, 4));
        System.out.println(findLastLT(arrays, 6));
        System.out.println(findLastLT(arrays, 13));
        System.out.println(findLastLT(arrays, 12));
        System.out.println(findLastLT(arrays, 26));

        System.out.println("----------");
        arrays = new int[]{1,1,3,5,6,6,6,12,12,25,25};
        System.out.println(findLastLT1(arrays, 0));
        System.out.println(findLastLT1(arrays, 1));
        System.out.println(findLastLT1(arrays, 4));
        System.out.println(findLastLT1(arrays, 6));
        System.out.println(findLastLT1(arrays, 13));
        System.out.println(findLastLT1(arrays, 12));
        System.out.println(findLastLT1(arrays, 26));
    }*/

}
