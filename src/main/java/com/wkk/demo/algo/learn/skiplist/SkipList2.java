package com.wkk.demo.algo.learn.skiplist;

/**
 * @Description 跳表的代码实现
 * @Author Wangkunkun
 * @Date 2020/8/10 14:47
 */
public class SkipList2 {

    /**
     * 最大层数
     */
    private static final int MAX_LEVEL = 32;

    /**
     * 提升概率
     */
    private static final float SKIPLIST_P = 0.5f;

    /**
     * 带头链表
     */
    private Node head = new Node(MAX_LEVEL);

    /**
     * 层数
     */
    private int levelCount;

    public Node find(int value) {
        Node node = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (node.forwards[i] != null && node.forwards[i].data < value) {
                node = node.forwards[i];
            }
        }
        if(node.forwards[0] != null && node.forwards[0].data == value) {
            return node.forwards[0];
        }else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node(level);
        newNode.data = value;
        Node p = head;
        // 更新前后节点
        for (int i = level - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            newNode.forwards[i] = p.forwards[i];
            p.forwards[i] = newNode;
        }

        if (levelCount < level) {
            levelCount = level;
        }
    }

    public void delete(int value) {
        Node node = head;
        Node[] update = new Node[levelCount];
        for (int i = levelCount - 1; i >= 0; i--) {
            while (node.forwards[i] != null && node.forwards[i].data < value) {
                node = node.forwards[i];
            }
            update[i] = node;
        }
        if(node.forwards[0] == null || node.forwards[0].data != value) {
            return;
        }
        for (int i = node.level - 1; i >= 0; i--) {
            // 判断第 i 层索引是否有要删除的结点
            if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                update[i].forwards[i] = update[i].forwards[i].forwards[i];
            }
        }
    }
    /**
     * 获取随机level
     * @return
     */
    private int randomLevel() {
        int level = 1;
        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
            level ++;
        }
        return level;
    }

    class Node {
        int data = -1;

        int level;

        /**
         * 表示当前节点在不同层的下一节点的位置，数组下标表示层数
         * 例如：forwards[3]表示当前节点在第三层的下一个节点。
         */
        Node[] forwards;

        public Node(int level) {
            this.level = level;
            this.forwards = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(level);
            builder.append(" }");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList2 skipList = new SkipList2();
        skipList.insert(1);
        skipList.insert(3);
        skipList.insert(4);
       /* System.out.println(skipList.find(1));
        System.out.println(skipList.find(2));
        System.out.println(skipList.find(4));*/
        skipList.insert(5);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(8);
        skipList.insert(9);
        skipList.insert(10);
        skipList.insert(13);
        skipList.insert(14);
        skipList.insert(16);
        skipList.insert(17);
        skipList.insert(18);
        System.out.println(skipList.find(8));
        System.out.println(skipList.find(17));
        System.out.println(skipList.find(18));
        System.out.println(skipList.find(20));
        skipList.delete(13);
        System.out.println(skipList.find(13));
        System.out.println(skipList);
    }
}
