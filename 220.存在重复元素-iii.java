/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
import java.util.*;
class Solution {
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     TreeSet<Long> set = new TreeSet<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         Long c = set.ceiling((long)nums[i]);
    //         if (c != null && c - nums[i] <= t)
    //             return true;
    //         Long f = set.floor((long)nums[i]);
    //         if (f != null && nums[i] - f <= t)
    //             return true;
    //         set.add((long)nums[i]);
    //         if (set.size() > k) {
    //             set.remove((long)nums[i-k]);
    //         }
    //     }
    //     return false;
    // }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        HashMap<Long, Long> map = new HashMap<>();
        int n = nums.length;
        long w = t + 1; // 一个桶里边数字范围的个数是 t + 1
        for (int i = 0; i < n; i++) {
            //删除窗口中第一个数字
            if (i > k) {
                map.remove(getId(nums[i - k - 1], w));
            }
            //得到当前数的桶编号
            long id = getId(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id + 1) && map.get(id + 1) - nums[i] < w) {
                return true;
            }

            if (map.containsKey(id - 1) && nums[i] - map.get(id - 1) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
        }
        return false;
    }

    private long getId(long num, long w) {
        if (num >= 0) {
            return num / w;
        } else {
            return (num + 1) / w - 1;
        }
    }
}
// @lc code=end

