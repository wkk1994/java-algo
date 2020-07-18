package com.wkk.demo.algo.learn.stack;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Description 栈的应用
 * @Author Wangkunkun
 * @Date 2020/7/18 21:40
 */
public class StackUse {

    /*public BigDecimal expressionsSum(String expression) {
        if(expression == null) {
            return null;
        }

    }*/

    private static Set<String> leftSet = new HashSet<>();
    static {
        leftSet.add("{");
        leftSet.add("[");
        leftSet.add("(");
    }

    /**
     * 栈在括号匹配中的应用
     * {[()[]} false
     * @param bracket
     * @return
     */
    public static boolean bracketMatch(String bracket) {
        if(bracket == null) {
            return false;
        }
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < bracket.length(); i++) {
            if(leftSet.contains(String.valueOf(bracket.charAt(i)))) {
                stringStack.add(String.valueOf(bracket.charAt(i)));
            }else {
                if(stringStack.empty()) {
                   return false;
                }
                String pop = stringStack.pop();
                if(!checkFlag(pop, String.valueOf(bracket.charAt(i)))){
                    return false;
                }
            }
        }
        return stringStack.empty();
    }

    private static boolean checkFlag(String left, String right) {
        if("[".equals(left) && "]".equals(right)) {
            return true;
        }else if("{".equals(left) && "}".equals(right)) {
            return true;
        }else if("(".equals(left) && ")".equals(right)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(bracketMatch("{}[](){[]{}()[{()[}]}"));
        System.out.println(bracketMatch("{}[](){[]{}()[{()[]}"));
        System.out.println(bracketMatch("{}[](){[({[]()})]}"));
        System.out.println(bracketMatch("(((((((((((())))))))"));
    }
}
