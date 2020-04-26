/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
import java.util.Stack;
class Solution {
    public int longestValidParentheses(String s) {
        // dp
        // int res = 0;
        // int dp[] = new int[s.length()];
        // for (int i = 1; i < s.length(); i++) {
        //     if (s.charAt(i) == ')') {
        //         if (s.charAt(i - 1) == '(') {
        //             dp[i] = i>=2 ? dp[i-2] + 2 : 2;
        //         } else if (i-dp[i-1] > 0 
        //                 && s.charAt(i-dp[i-1]-1) == '(') {
        //             dp[i] = dp[i-1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
    
        //         }
        //         res = Math.max(res, dp[i]);
        //     }
        // }
        // return res;
        // 用栈
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i-stack.peek());
                }
            }
        }
        return res;
    }
}
// @lc code=end

