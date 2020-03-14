/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
import java.util.ArrayList;
class Solution {
    ArrayList<String> res= new ArrayList<>();
    int n = 0;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        gene("", 0, 0);
        return res;
    }
    private void gene(String s, int l, int r) {
        if (s.length() == 2*n) {
            res.add(s);
            return;
        }
        if (l < n)
            gene(s+"(", l+1, r);
        if (r < l)
            gene(s+")", l, r+1);
    }
}
// @lc code=end

