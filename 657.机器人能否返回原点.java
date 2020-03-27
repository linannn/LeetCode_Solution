/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        int lr = 0;
        int ud = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R')
                lr++;
            else if (moves.charAt(i) == 'L')
                lr--;
            else if (moves.charAt(i) == 'U')
                ud++;
            else
                ud--;
        }
        return lr == 0 && ud == 0;
    }
}
// @lc code=end

