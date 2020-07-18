package com.wkk.demo.algo.learn.linked;


/**
 * @Description 链表判断是否为回字符串实现
 * @Author Wangkunkun
 * @Date 2020/7/4 16:48
 */
public class ReturnStringLinkedList {

    /**
     * 单向链表判断是否为回字符串
     * 实现方式：通过一个快指针和一个慢指针先找到中间节点，反转中间节点的前节点，然后通过两个指针从中间向后遍历进行比较
     * @return
     */
    public static boolean checkOneWayIsReturnString(LinkedList<String> linkedList) {
        // 链表为空或长度小于等于1，不认为是回字符串
        if(linkedList == null || linkedList.size() <= 1) {
            return false;
        }
        LinkedList.LinkedListNode prev = null;
        LinkedList.LinkedListNode fast = linkedList.head;
        LinkedList.LinkedListNode slow = linkedList.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            LinkedList.LinkedListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // 用于还原链表
        LinkedList.LinkedListNode node = slow;
        LinkedList.LinkedListNode lodPrev = prev;
        // 根据链表长度的奇偶判断开始比较的开始点
        if(fast != null) {
            slow = slow.next;
        }
        boolean flag = true;
        while (slow != null) {
            if(!slow.value.equals(prev.value)) {
                flag = false;
                break;
            }
            slow = slow.next;
            prev = prev.next;
        }
        // 链表还原
        while (lodPrev != null) {
            LinkedList.LinkedListNode nodeTmp = lodPrev.next;
            lodPrev.next = node;
            node = lodPrev;
            lodPrev = nodeTmp;
        }
        return flag;
    }

    /**
     * 双向链表判断是否为回字符串方式
     * 实现方式：双指针法，头部指针向后遍历，尾部指针向前遍历进行比较，直到中间节点或过了中间双节点。
     * @return
     */
    public static boolean checkTwoWayIsReturnString(LinkedList<String> linkedList) {
        // 链表为空或长度小于等于1，不认为是回字符串
        if(linkedList == null || linkedList.size() <= 1) {
            return false;
        }
        LinkedList.LinkedListNode head = linkedList.head;
        LinkedList.LinkedListNode tail = linkedList.tail;

        while(tail.next != head && tail != head) {
            if(!tail.value.equals(head.value)) {
                return false;
            }
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("c");
        linkedList.add("b");
        linkedList.add("a");
        System.out.println(checkOneWayIsReturnString(linkedList));
        System.out.println(checkTwoWayIsReturnString(linkedList));

    }
}
