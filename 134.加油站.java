/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // if (gas == null || gas.length == 0 || gas.length < cost.length) {
        //     return -1;
        // }
        // int len = gas.length;
        // for (int start = 0; start < len; start++) {
        //     int idx = start;
        //     int last = gas[start];
        //     for (int i = 0; i < len-1; i++) {
        //         last = last - cost[idx];
        //         if (last < 0) {
        //             break;
        //         }
        //         idx = (idx + 1) % len;
        //         last += gas[idx];
        //     }
        //     last -= cost[idx];
        //     if (last >= 0) {
        //         return start;
        //     }
        // }
        // return -1;
    int len = gas.length;
    int spare = 0;
    int minSpare = Integer.MAX_VALUE;
    int minIndex = 0;

    for (int i = 0; i < len; i++) {
        spare += gas[i] - cost[i];
        if (spare < minSpare) {
            minSpare = spare;
            minIndex = i;
        }
    }

    return spare < 0 ? -1 : (minIndex + 1) % len;
    }

}
// @lc code=end

