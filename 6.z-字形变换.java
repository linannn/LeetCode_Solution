/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        int length = s.length();
        if (numRows == 1 || length <= numRows)
            return s;
        ArrayList<StringBuilder> sb = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            sb.add(new StringBuilder());
        int cur = 0;
        boolean flag = false;
        for (char ch : s.toCharArray()) {
            sb.get(cur).append(ch);
            if (cur == 0 || cur == numRows -1)
                flag = ! flag;
            cur += flag ? 1 : -1;
        }
        for (int i = 1; i < sb.size(); i++) {
            sb.get(0).append(sb.get(i));
        }
        return sb.get(0).toString();
    }
}
// @lc code=end

