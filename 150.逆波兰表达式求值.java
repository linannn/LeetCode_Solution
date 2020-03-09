/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num1, num2;
        for(String s : tokens) {
            if (s.equals("+")) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1+num2);
            } else if (s.equals("-")) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1-num2);
            } else if (s.equals("*")) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1*num2);
            } else if (s.equals("/")) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push((int)num1/num2);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
// @lc code=end

