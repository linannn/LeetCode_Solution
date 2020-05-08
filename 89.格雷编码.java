/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j)+head);
            }
            head = head << 1;
        }
        return res;
    }
}
// @lc code=end

