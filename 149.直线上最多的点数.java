/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int same = 0;
            int max = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i+1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0){
                    same++;
                    continue;
                }
                double k = x / (y+0.0);
                String key;
                if (x == 0) {
                    key = "0";
                } else if (y == 0) {
                    key = "inf";
                } else {
                    key = k + "";
                }
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + same + 1);
        }
        return res;
    }
}
// @lc code=end

