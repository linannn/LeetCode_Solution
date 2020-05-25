/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
import java.util.*;
class Solution {
    ArrayDeque<Integer> deq = new ArrayDeque<>();
    int [] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0)
            return new int[0];
        if (1 == k)
            return nums;
        int[] res = new int[len - k + 1];
        this.nums = nums;
        for (int i = 0; i < k - 1; i++) {
            cleanQueue(i, k);
            deq.addLast(i);

        }
        for (int i = k - 1; i < len; i++) {
            cleanQueue(i, k);
            deq.addLast(i);
            res[i - k + 1] = nums[deq.getFirst()];
        }

        return res;
    }

    private void cleanQueue(int i, int k) {
        if (!deq.isEmpty() && deq.peekFirst() == i - k) {
            deq.removeFirst();
        }
        while (!deq.isEmpty() && nums[i] > nums[deq.peekLast()]) {
            deq.removeLast();
        }
    }
}
// @lc code=end

