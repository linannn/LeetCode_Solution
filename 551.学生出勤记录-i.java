/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        int idx = s.indexOf('A');
        return !(s.indexOf('A', idx+1) != -1 || s.indexOf("LLL") != -1);

    }
}
// @lc code=end

