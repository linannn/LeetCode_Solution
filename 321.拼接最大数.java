/*
 * @lc app=leetcode.cn id=321 lang=java
 *
 * [321] 拼接最大数
 */

// @lc code=start
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null ||
            k > nums1.length + nums2.length) 
            return null;
        int l1 = nums.length;
        int l2 = nums.length;
        int[] res = new int[k];
        res[0] = Math.min(nums1[l1-1], nums2[l2-1]);
        int i = l1-1;
        int j = l2-1;
        while (i >= 0 && j >= 0) {
            int max = Math.max(nums1[i], nums2[j]);
            if (max > res[0]) {
                leftShift(res);
                res[0] = max;
            }
        }


    }
    private void leftShift(int[] nums) {
        for (int i = nums.length-1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
    }
}
// @lc code=end

