/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length-1;
        char tmp;
        while (start < end) {
            while (start < end && !isYuan(arr[start]))
                start++;
            while (start < end && !isYuan(arr[end]))
                end--;
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        // StringBuilder sb = new StringBuilder
        return new String(arr);
    }
    private boolean isYuan(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U': return true;
            default: return false;
        }
    }
}
// @lc code=end

