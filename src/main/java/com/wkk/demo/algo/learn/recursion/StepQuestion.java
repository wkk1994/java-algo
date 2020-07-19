package com.wkk.demo.algo.learn.recursion;

/**
 * @Description 台阶问题使用递归求解
 * 问题描述：假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
 * @Author Wangkunkun
 * @Date 2020/7/19 14:28
 */
public class StepQuestion {

    /**
     * 使用递归求解台阶问题
     * @param n
     * @return
     */
    public static int recursionClimbStairs(int n) {
        if(n == 1) {
            return 1;
        }else if(n == 2){
            return 2;
        }
        return recursionClimbStairs(n-1) + recursionClimbStairs(n -2);
    }

    /**
     * 非递归求解台阶问题
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }else if(n == 2){
            return 2;
        }
        int pre = 2;
        int prePre = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = prePre + pre;
            prePre = pre;
            pre = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
        System.out.println(climbStairs(7));
        System.out.println(climbStairs(8));
        System.out.println(climbStairs(9));
        System.out.println(climbStairs(10));
        System.out.println(climbStairs(45));
        System.out.println(climbStairs(44));
        System.out.println(1 + 2147483642);
    }
}
