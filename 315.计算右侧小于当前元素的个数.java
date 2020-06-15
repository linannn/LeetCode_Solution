/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start
class Solution {
    private int[] helper;
    private int[] index;
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int len = nums.length;
        helper = new int[len];
        index = new int[len];
        count = new int[len];
        for (int i = 0; i < len; i++) 
            index[i] = i;
        merge(nums, 0, len-1);
        for (int i = 0; i < len; i++)
            res.add(count[i]);
        return res;
    }
    private void merge(int[] nums, int s, int e) {
        if (s >= e)
            return;
        
        int mid = (s + e) >> 1;
        merge(nums, s, mid);
        merge(nums, mid + 1, e);
        int i = s;
        int j = mid + 1;
        int idx = s;
        while (i <= mid && j <= e) {
            if (nums[index[i]] <= nums[index[j]]) {
                helper[idx++] = index[j++];
            } else {
                count[index[i]] += e - j + 1;
                helper[idx++] = index[i++];
            }
        }
        while (i <= mid)
            helper[idx++] = index[i++];
        while (j <= e)
            helper[idx++] = index[j++];
        for (int k = s; k <= e; k++) 
            index[k] = helper[k];
    }
}
// @lc code=end

