/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1StrArr = version1.split("\\.");
        String[] v2StrArr = version2.split("\\.");
        int len = Math.max(v2StrArr.length, v1StrArr.length);
        int[] v1 = new int[len];
        int[] v2 = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < v1StrArr.length)
                v1[i] = Integer.valueOf(v1StrArr[i]);
            if (i < v2StrArr.length)
                v2[i] = Integer.valueOf(v2StrArr[i]);
            if (v1[i] > v2[i])
                return 1;
            if (v1[i] < v2[i])
                return -1;
        }
        return 0;
    }
}
// @lc code=end

