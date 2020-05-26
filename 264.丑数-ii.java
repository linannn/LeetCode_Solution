/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
import java.util.*;
class Solution {
    public int nthUglyNumber(int n) {
        // Set<Long> seen = new HashSet<>();
        // PriorityQueue<Long> queue = new PriorityQueue<>();
        // queue.offer(1L);
        // int count = 0;
        // int[] multiply = new int[]{2, 3, 5};
        // while (true) {
        //     long s = queue.poll();
        //     count++;
        //     if (count == n) {
        //         return (int) s;
        //     }
        //     for (int num : multiply) {
        //         long newUgly = num * s;
        //         if (!seen.contains(newUgly)) {
        //             queue.offer(newUgly);
        //             seen.add(newUgly);
        //         }
        //     }
        // }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 1; i < n; i++) {
            int f2 = 2 * ugly[idx2];
            int f3 = 3 * ugly[idx3];
            int f5 = 5 * ugly[idx5];
            int m = Math.min(Math.min(f2, f3), f5);
            ugly[i] = m;
            if (f2 == m)
                idx2++;
            if (f3 == m)
                idx3++;
            if (f5 == m)
                idx5++;
        }
        return ugly[n-1];
    }
}
// @lc code=end

