/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        // dp
        // int sLen = s.length();
        // int pLen = p.length();
        // boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        // dp[0][0] = true;
        // for (int i = 1; i < pLen + 1; i++) {
        //     dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        // }
        // for (int i = 1; i < sLen + 1; i++) {
        //     for (int j = 1; j < pLen + 1; j++) {
        //         if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
        //             dp[i][j] = dp[i-1][j-1];
        //         } else if (p.charAt(j-1) == '*') {
        //             dp[i][j] = dp[i-1][j] || dp[i][j-1];
        //         }
        //     }
        // }
        // return dp[sLen][pLen];
        int i = 0, j = 0, iStar = -1, jStar = -1, m = s.length(), n = p.length();
        while (i < m) {
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;//i，j向后瞬移
            } else if (j < n && p.charAt(j) == '*') {//记录如果之后序列匹配不成功时， i和j需要回溯到的位置
                iStar = i;//记录星号
                jStar = j;//记录星号 并且j移到下一位 准备下个循环s[i]和p[j]的匹配
                j++;
            } else if (iStar >= 0) {//发现字符不匹配且没有星号出现 但是istar>0 说明可能是*匹配的字符数量不对 这时回溯
                i = iStar;//i回溯到istar+1 因为上次从s串istar开始对*的尝试匹配已经被证明是不成功的（不然不会落入此分支） 所以需要从istar+1再开始试 同时inc istar 更新回溯位置
                iStar++;
                j = jStar + 1;//j回溯到jstar+1 重新使用p串*后的部分开始对s串istar（这个istar在上一行已经inc过了）位置及之后字符的匹配
            } else
                return false;
        }
        while (j < n && p.charAt(j) == '*')
            j++;//去除多余星号
        return j == n;
    }
}
// @lc code=end

