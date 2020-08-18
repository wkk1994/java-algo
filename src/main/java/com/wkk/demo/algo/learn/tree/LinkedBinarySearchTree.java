package com.wkk.demo.algo.learn.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 链式法的二叉查找树
 * @Author Wangkunkun
 * @Date 2020/8/8 16:22
 */
public class LinkedBinarySearchTree<T extends Comparable> {

    private Node root;

    static class Node<T extends Comparable>{
        T data;

        Node left;

        Node right;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 查找指定数据
     * @param t
     * @return
     */
    public Node find(T t) {
        Node p = root;
        while (p != null) {
            if(p.data.equals(t)) {
                return p;
            }else if(p.data.compareTo(t) > 0) {
                p = p.left;
            }else {
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 插入数据
     * @param t
     */
    public void insert(T t) {
        Node value = new Node(t);
        if(root == null) {
            root = value;
            return;
        }
        Node p = root;
        while (p != null) {
            if(p.data.compareTo(value.data) > 0) {
                if(p.left == null) {
                    p.left = value;
                    return;
                }else {
                    p = p.left;
                }
            }else {
                if(p.right == null) {
                    p.right = value;
                    return;
                }else {
                    p = p.right;
                }
            }
        }
    }

    /**
     * 删除指定元素
     * @param t
     */
    public void delete(T t) {
        Node node = root;
        Node pNode = null;
        while (node != null) {
            if(node.data.compareTo(t) == 0) {
                break;
            }else if(node.data.compareTo(t) > 0) {
                pNode = node;
                node = node.left;
            }else {
                pNode = node;
                node = node.right;
            }
        }
        if(node == null) {
            return;
        }
        if(node.left != null && node.right != null) {
            // 在右树中查询最小的左节点
            Node minNode = node.right;
            Node minPNode = node;
            while (minNode.left != null){
                minPNode = minNode;
                minNode = minNode.left;
            }
            node.data = minNode.data; // 将minNode的数据替换到node中
            node = minNode; // 下面就变成了删除minNode了
            pNode = minPNode;
        }
        Node child = null;
        if(node.left != null) {
            child = node.left;
        }else if(node.right != null) {
            child = node.right;
        }else {
            child = null;
        }
        if(pNode == null) {
            root = child;
        }else if(pNode.left == node) {
            pNode.left = child;
        }else {
            pNode.right = child;
        }
    }

    /**
     * 获取二叉树的高度
     * 实现方式一：深度优先思想的递归，分别求左右子树的高度。当前节点的高度就是左右子树中较大的那个+1；
     * @param root
     * @return
     */
    public static int getHeightOne(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 0;
        }
        return Math.max(getHeightOne(root.left), getHeightOne(root.right)) + 1;
    }

    /**
     * 获取二叉树的高度
     * 实现方式二：采用层次遍历的方式
     * @param root
     * @return
     */
    public static int getHeightTwo(Node root) {
        if(root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int floor = 1;
        int front = 0; // 队头
        int rear = queue.size();// 队尾

        while (!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.right != null){
                queue.offer(poll.right);
            }
            if(poll.left != null) {
                queue.offer(poll.left);
            }
            front ++;
            if(front == rear && !queue.isEmpty()) {
                floor ++;
                rear = queue.size();
                front = 0;
            }
        }
        return floor - 1;
    }

    public static void main(String[] args) {
        LinkedBinarySearchTree linkedBinarySearchTree = new LinkedBinarySearchTree();
        linkedBinarySearchTree.insert(33);
        linkedBinarySearchTree.insert(16);
        linkedBinarySearchTree.insert(50);
        linkedBinarySearchTree.insert(15);
        linkedBinarySearchTree.insert(19);
        linkedBinarySearchTree.insert(17);
        linkedBinarySearchTree.insert(25);
        linkedBinarySearchTree.insert(27);
        linkedBinarySearchTree.insert(34);
        linkedBinarySearchTree.insert(58);
        linkedBinarySearchTree.insert(51);
        linkedBinarySearchTree.insert(66);
        linkedBinarySearchTree.insert(69);
        linkedBinarySearchTree.insert(90);

        Node a = linkedBinarySearchTree.find(25);
        System.out.println(a);
        if(a != null) {
            System.out.println(a.data);
        }
        linkedBinarySearchTree.delete(33);
        System.out.println(linkedBinarySearchTree);
        System.out.println(getHeightOne(linkedBinarySearchTree.root));
        System.out.println(getHeightTwo(linkedBinarySearchTree.root));
    }
}
