/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
import java.util.HashSet;
class Solution {
    private HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) 
            return true;
        if (set.contains(n))
            return false;
        set.add(n);
        int nNew = 0;
        String nStr = n+"";
        for (int i = 0; i < nStr.length(); i++) {
            nNew += Math.pow(nStr.charAt(i)-'0', 2);
        }
        return isHappy(nNew);
    }
}
// @lc code=end

