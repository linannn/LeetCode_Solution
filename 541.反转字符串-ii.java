/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int start, end;
        char tmp;
        for (int i = 0; i < arr.length; i += 2*k) {
            start = i;
            end = Math.min(i+k-1, arr.length-1);
            while (start < end) {
                tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }
        return new String(arr);
    }
}
// @lc code=end

