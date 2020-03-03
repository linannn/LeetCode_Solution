#
# @lc app=leetcode.cn id=532 lang=python3
#
# [532] 数组中的K-diff数对
#

# @lc code=start


class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        ori_set = set(nums)
        res_min_set = set()
        if k < 0:
            return 0
        if k == 0:
            return len(set([i for i in nums if nums.count(i) >= 2]))
        for i in ori_set:
            if i + k in ori_set:
                res_min_set.add(i)
            if i - k in ori_set:
                res_min_set.add(i-k)
        return len(res_min_set)
# @lc code=end
