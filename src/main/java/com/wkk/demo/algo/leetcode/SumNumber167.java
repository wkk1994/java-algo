package com.wkk.demo.algo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Description
 * @Author Wangkunkun
 * @Date 2020/7/8 17:26
 */
public class SumNumber167 {

    /**
     * 题目描述：在有序数组中找出两个数，使它们的和为 target。
     * 167. Two Sum II - Input array is sorted (Easy)
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     * 实现方式：使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length <= 1) {
            return null;
        }
        int head = 0, tail = numbers.length - 1;
        while (head < tail) {
            int total = numbers[head] + numbers[tail];
            if(total == target) {
                return new int[]{head, tail};
            }else if(total > target) {
                tail --;
            }else {
                head ++;
            }
        }
        return null;
    }


    /**
     * 题目描述：判断一个非负整数是否为两个整数的平方和。
     * 633. Sum of Square Numbers (Easy)
     * Input: 5
     * Output: True
     * Explanation: 1 * 1 + 2 * 2 = 5
     * 实现方式：使用双指针，方法和上面类似。时间复杂度为 O(sqrt(target))
     * @param target
     * @return
     */
    public static boolean judeSquareSum(int target) {
        if(target <= 0) {
            return false;
        }
        int head = 1, tail = (int)Math.sqrt(target);
        while(head <= tail) {
            int sum = head * head + tail * tail;
            if(sum == target) {
                System.out.println("head: " + head + " tail: " + tail);
                return true;
            } else if(sum > target) {
                tail --;
            } else {
                head --;
            }
        }
        return false;
    }

    /**
     * 题目描述：反转字符串中的元音字符
     * 345. Reverse Vowels of a String (Easy)
     * Given s = "leetcode", return "leotcede".
     * 实现方式：使用双指针，一个从头开始遍历，一个从尾开始遍历。当两个指针都遍历到元音字符时进行交换。为了快速判断一个字符是不是元音字符，
     * 可以将所有的元音字符添加到hashSet中，从而以O(1)的时间复杂度判断一个字符是否为元音。
     * 时间复杂度为 O(N)：只需要遍历所有元素一次
     * 空间复杂度 O(1)：只需要使用两个额外变量
     * @param string
     * @return
     */
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String word) {
        if(word == null) {
            return null;
        }
        int head = 0, tail = word.length() - 1;
        char[] result = new char[word.length()];
        while (head <= tail) {
            char headChar = word.charAt(head);
            char tailChar = word.charAt(tail);
            if(vowels.contains(headChar) && vowels.contains(tailChar)) {
                result[head ++] = tailChar;
                result[tail --] = headChar;
                continue;
            }
            if(!vowels.contains(headChar)) {
                result[head ++] = headChar;
            }
            if(!vowels.contains(tailChar)) {
                result[tail --] = tailChar;
            }
        }
        return new String(result);
    }

    /**
     * 题目描述：可以删除一个字符，判断是否能构成回文字符串。
     * 680. Valid Palindrome II (Easy)
     * Input: "abca"
     * Output: True
     * Explanation: You could delete the character 'c'.
     * 实现方式：使用双指针，一个从左向右遍历，一个从右向左遍历，比较两个指针的值是否相同，如果出现不相等的情况删除左/右数据，比较下一个数据是否相等
     * 时间复杂度为 O(N)：只需要遍历所有元素一次
     * @param target
     */
    public static boolean validPalindrome(String target) {
        if(target == null || target.length() == 1) {
            return false;
        }
        int head = 0;
        int tail = target.length() - 1;
        while (head < tail) {
            if(target.charAt(head) != target.charAt(tail)) {
                return isPalindrome(target, ++head, tail) || isPalindrome(target, head, --tail);
            }
            head ++;
            tail --;
        }
        return true;
    }

    private static boolean isPalindrome(String target, int head, int tail) {
        while (head < tail) {
            if (target.charAt(head) != target.charAt(tail)) {
                return false;
            }
            head ++;
            tail --;
        }
        return true;
    }

    /**
     * 题目描述：判断链表是否存在环
     * 141. Linked List Cycle (Easy)
     * 实现方式一：使用哈希表，保存访问过的节点，如果存在一个节点重复出现就出现环。时间复杂度O(N)，空间复杂度：O(N)。
     * 实现方式二：使用双指针，一个快指针和一个慢指针，如果快指针追上慢指针说明存在环
     * 空间复杂度：O(1)，只使用了快慢2个指针空间
     * 时间复杂度：O(N)，当没有环的时候，需要遍历一遍链表，时间复杂度为O(N)；当存在环的时候，环的长度为K，快指针最差需要走K步追上慢指针，时间复杂度为O(N + K)，就是O(N)。
     * @param head
     * @return
     */
    private static boolean hasCycle(ListNode head) {
      if(head == null) {
        return false;
      }
      ListNode next = head;
      ListNode nextNext = head.next;
      while (nextNext != null && next != null && nextNext.next != null){
          if(next == nextNext) {
              return true;
          }
          next = next.next;
          nextNext = nextNext.next.next;
      }
      return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 题目描述：删除 s 中的一些字符，使得它构成字符串列表 list 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
     *
     * @param s
     * @param list
     * @return
     */
    /*private static String findLongestWord(String s, List<String> list) {

    }*/
    public static void main(String[] args) {
        // 有序数组两数之和测试
        //System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 13)));
        //System.out.println(judeSquareSum(6));
        //System.out.println(reverseVowels("leetcode"));
        //System.out.println(validPalindrome("dasdfgfd33sad"));
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode thread = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = thread;
        thread.next = four;
        four.next = null;

        System.out.println(hasCycle(one));
    }
}
