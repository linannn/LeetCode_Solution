/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    private char[] arr;
    public boolean validPalindrome(String s) {
        this.arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (arr[start] == arr[end]) {
                start++;
                end--;
            } else {
                return helper(start, end-1) || helper(start+1, end);
            }
        }
        return true;
    }

    private boolean helper(int start, int end) {
        while (start <= end) {
            if (arr[start] == arr[end]){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

