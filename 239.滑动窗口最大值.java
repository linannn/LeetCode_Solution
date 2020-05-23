/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 0; i < k - 1; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            heap.offer(nums[i]);
            res[i - k + 1] = heap.peek();
            Integer tmp = nums[i - k + 1];
            heap.remove(tmp);
        }
        return res;
    }
}
// @lc code=end

