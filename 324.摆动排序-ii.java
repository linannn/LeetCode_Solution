/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(tmp);
        int end = nums.length-1;
        int mid = (nums.length & 1) == 1 ? nums.length / 2 : nums.length / 2 -1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i & 1) == 0 ? tmp[mid--] : tmp[end--];
        }
    }
}
// @lc code=end

