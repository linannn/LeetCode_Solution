/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(
            (n1, n2) -> n1 - n2
        );
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.poll();
    }
}
// @lc code=end

