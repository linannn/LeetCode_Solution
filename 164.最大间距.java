/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Bucket {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
}

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        //找到最小值、最大值
        int max = 0, min = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int bucketSize = Math.max((max - min) / (nums.length - 1), 1);
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
        //入桶,每个桶只关心桶内的最大值和最小值
        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] - min) / bucketSize;
            if (buckets[idx] == null) buckets[idx] = new Bucket();
            buckets[idx].max = Math.max(nums[i], buckets[idx].max);
            buckets[idx].min = Math.min(nums[i], buckets[idx].min);
        }
        int preMax = -1;
        int maxGap = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null && preMax != -1) {
                maxGap = Math.max(maxGap, buckets[i].min - preMax);
            }
            if (buckets[i] != null) {
                preMax = buckets[i].max;
            }
        }
        return maxGap;
    }
}
// @lc code=end

