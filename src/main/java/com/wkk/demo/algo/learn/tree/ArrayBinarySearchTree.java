package com.wkk.demo.algo.learn.tree;

import java.util.Arrays;

/**
 * @Description 顺序法实现的二分查找树
 * @Author Wangkunkun
 * @Date 2020/8/8 20:26
 */
public class ArrayBinarySearchTree {

    Integer[] array;

    int size;

    public ArrayBinarySearchTree() {
        array = new Integer[10];
        size = 10;
    }

    /**
     * 插入数据
     * @param t
     */
    public void insert(int t) {
        if(array == null) {
            array = new Integer[10];
            size = 10;
            array[1] = t;
            return;
        }
        insert(1, t);

    }

    private void insert(int index, int t) {
        while (index >= size) {
            // 超出后扩容
            size = size * 2;
            Integer[] temp = new Integer[size * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        if(array[index] == null) {
            array[index] = t;
        }else if(array[index] > t) {
            insert(2 * index, t);
        }else {
            insert(2 * index + 1, t);
        }
    }

    /**
     * 查找指定数据
     * @param t
     * @return
     */
    public int find(int t) {
        int index = 1;
        while (index < size) {
            if(array[index] == null) {
                return -1;
            } else if(array[index] == t) {
                return index;
            }else if(array[index] > t){
                index = 2 * index;
            }else {
                index = 2 * index + 1;
            }
        }
        return -1;
    }

    /**
     * 删除指定元素
     * @param t
     */
    public void delete(int t) {
        int index = find(t);
        if(index < 0){
            return;
        }
        if(2 * index < size && array[2 * index] != null
        && 2 * index + 1 < size && array[2 * index + 1] != null) {
            int minIndex = 2 * index + 1;
            while (2 * minIndex < size && array[2 * minIndex] != null){
                minIndex = 2 * minIndex;
            }
            array[index] = array[minIndex];
            index = minIndex;
        }
        if(2 * index < size && array[2 * index] != null) {
            array[index] = array[2 * index];
        } else if (2 * index + 1 < size && array[2 * index + 1] != null) {
            array[index] = array[2 * index + 1];
        }else {
            array[index] = null;
        }
    }

    public static void main(String[] args) {
        ArrayBinarySearchTree arrayBinarySearchTree = new ArrayBinarySearchTree();
        arrayBinarySearchTree.insert(33);
        arrayBinarySearchTree.insert(16);
        arrayBinarySearchTree.insert(50);
        arrayBinarySearchTree.insert(15);
        arrayBinarySearchTree.insert(19);
        arrayBinarySearchTree.insert(17);
        arrayBinarySearchTree.insert(25);
        arrayBinarySearchTree.insert(27);
        arrayBinarySearchTree.insert(34);
        arrayBinarySearchTree.insert(58);
        arrayBinarySearchTree.insert(51);
        arrayBinarySearchTree.insert(66);
        System.out.println(Arrays.toString(arrayBinarySearchTree.array));
        System.out.println(arrayBinarySearchTree.find(33));
        System.out.println(arrayBinarySearchTree.find(50));
        System.out.println(arrayBinarySearchTree.find(18));
        System.out.println(arrayBinarySearchTree.find(90));
        System.out.println(arrayBinarySearchTree.find(100));
        arrayBinarySearchTree.delete(19);
        System.out.println(Arrays.toString(arrayBinarySearchTree.array));
    }
}
