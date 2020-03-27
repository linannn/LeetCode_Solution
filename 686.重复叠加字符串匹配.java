/*
 * @lc app=leetcode.cn id=686 lang=java
 *
 * [686] 重复叠加字符串匹配
 */

// @lc code=start
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int num = (int) Math.ceil(B.length()/(A.length()+0.0));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(A);
        }
        if (builder.indexOf(B) != -1) 
            return num;
        builder.append(A);
        return builder.indexOf(B) != -1 ? num+1 : -1;

    }
}
// @lc code=end

