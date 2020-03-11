/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
import java.util.Stack;
class Solution {
    public static int myAtoi(String str) {
        long MAX = 2147483647;
        long MIN = -2147483648;
        boolean readFlag = true;
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (readFlag) {
                if (ch == ' ')
                    continue;
                else if (ch == '-' || ch == '+' || Character.isDigit(ch)) {
                    stack.push(ch);
                    readFlag = false;
                } else
                    return 0;
            } else {
                if (Character.isDigit(ch))
                    stack.push(ch);
                else
                    break;
            }
        }
        long res = 0;
        int wei = 0;
        char ch;
        double tmp;
        while (!stack.empty()) {
            ch = stack.pop();
            if (Character.isDigit(ch)) {
                tmp = Integer.parseInt(String.valueOf(ch)) * Math.pow(10, wei);
                if (tmp + res > MAX) {
                    res = MAX;
                }
                res += tmp;
                wei++;
            } else if (ch == '-')
                res = -res;
        }
        return (int) Math.max(Math.min(res, MAX), MIN);
    }
}
// @lc code=end

