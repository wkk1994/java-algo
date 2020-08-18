package com.wkk.demo.algo.learn.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 顺序法实现的二叉树
 * @Author Wangkunkun
 * @Date 2020/8/8 14:03
 */
public class ArrayBinaryTree {

    String[] arrays;

    /**
     * 前序遍历
     * @param index
     */
    public void preOrder(int index) {
        if(index < 0 || index >= arrays.length) {
            return;
        }
        System.out.println(arrays[index]);
        preOrder(2 * index);
        preOrder(2 * index + 1);
    }

    /**
     * 中序遍历
     * @param index
     */
    public void inOrder(int index) {
        if(index < 0 || index >= arrays.length) {
            return;
        }
        inOrder(2 * index);
        System.out.println(arrays[index]);
        inOrder(2 * index + 1);
    }


    /**
     * 后序遍历
     * @param index
     */
    public void postOrder(int index) {
        if(index < 0 || index >= arrays.length) {
            return;
        }
        postOrder( 2 * index);
        postOrder(2 * index + 1);
        System.out.println(arrays[index]);
    }

    /**
     * 按层遍历
     */
    public void layerOrderAsc(int index) {
        if(index < 0 || index >= arrays.length) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if(poll >= arrays.length) {
                return;
            }
            System.out.println(arrays[poll]);
            queue.offer(2 * poll);
            queue.offer(2 * poll + 1);
        }
    }

    public static void main(String[] args) {
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree();
        String[] arrays = new String[]{"", "A", "B", "C", "D", "E", "F", "G"};
        arrayBinaryTree.arrays = arrays;
        arrayBinaryTree.preOrder(1);
        System.out.println("--------");
        arrayBinaryTree.inOrder(1);
        System.out.println("--------");
        arrayBinaryTree.postOrder(1);
        System.out.println("--------");
        arrayBinaryTree.layerOrderAsc(1);
        System.out.println("--------");
    }
}
