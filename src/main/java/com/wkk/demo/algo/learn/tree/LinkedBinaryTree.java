package com.wkk.demo.algo.learn.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 链式法存储实现的二叉树
 * @Author Wangkunkun
 * @Date 2020/8/8 13:03
 */
public class LinkedBinaryTree {

    private Node root;

    static class Node<T>{
        T data;

        Node left;

        Node right;

        public Node() {
        }

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }


    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    /**
     * 按层遍历，通过使用队列辅助实现
     */
    public void layerOrderAsc(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.data);
            if(poll.left != null) {
                queue.offer(poll.left);
            }
            if(poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    public static void main(String[] args) {
        Node<String> left = new Node<>();
        left.data = "D";
        Node<String> right = new Node<>();
        right.data = "E";
        Node<String> root = new Node<>();
        root.data = "B";
        root.right = right;
        root.left = left;
        left = root;

        Node<String> left1 = new Node<>();
        left1.data = "F";
        Node<String> right1 = new Node<>();
        right1.data = "G";
        Node<String> root1 = new Node<>();
        root1.data = "C";
        root1.right = right1;
        root1.left = left1;
        right = root1;

        root = new Node<>();
        root.data = "A";
        root.left = left;
        root.right = right;

        LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree();
        linkedBinaryTree.preOrder(root);
        System.out.println("--------");
        linkedBinaryTree.inOrder(root);
        System.out.println("--------");
        linkedBinaryTree.postOrder(root);
        System.out.println("--------");
        linkedBinaryTree.layerOrderAsc(root);
    }
}
