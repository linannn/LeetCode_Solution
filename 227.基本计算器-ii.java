/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Stack;
class Solution {
    public int calculate(String s) {
        Deque<String> li = new LinkedList<>(Arrays.asList(s.split("")));
        String sign = "+";
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        String ch = "";
        while (!li.isEmpty()) {
            ch = li.pollFirst();
            if (Character.isDigit(ch.charAt(0))) {
                num = num * 10 + Integer.parseInt(ch);
            }
            if (!Character.isDigit(ch.charAt(0)) && ch.charAt(0) != ' ' || li.isEmpty()) {
                switch (sign) {
                    case "+":
                        stack.push(num);
                        break;
                    case "-":
                        stack.push(-num);
                        break;
                    case "*":
                        stack.push(num * stack.pop());
                        break;
                    case "/":
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                sign = ch;
            }
        }
        return stack.stream().mapToInt(item -> item).sum();
    }
}
// @lc code=end

