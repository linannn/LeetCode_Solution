/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int cur = wordToInt(s.charAt(0));
        int next = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            next = wordToInt(s.charAt(i+1));
            if (next > cur)
                sum -= cur;
            else
                sum += cur;
            cur = next;
        }
        return sum + wordToInt(s.charAt(s.length() - 1));

    }
    public int wordToInt(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
// @lc code=end

