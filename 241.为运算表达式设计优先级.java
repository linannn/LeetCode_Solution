/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start
import java.util.*;
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0) {
            return new ArrayList<>();
        }
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> res = new ArrayList<>();
        int num = 0;
        int idx = 0;
        while (idx < input.length() && !isOp(input.charAt(idx))){
            num = num * 10 + input.charAt(idx) - '0';
            idx++;
        }
        if (idx == input.length()) {
            res.add(num);
            return res;
        }
        for (int i = 0; i < input.length(); i++) {
            if (isOp(input.charAt(i))) {
                List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(input.substring(i+1));
                for(int r1 : res1) {
                    for (int r2 : res2) {
                        res.add(calc(input.charAt(i), r1, r2));
                    }
                }
            }
        }
        return res;
    }
    private int calc(char op, int m, int n) {
        if (op == '+') {
            return m + n;
        } else if (op == '-') {
            return m - n;
        } else {
            return m*n;
        }
    }

    private boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}
// @lc code=end

