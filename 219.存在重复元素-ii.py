#
# @lc app=leetcode.cn id=219 lang=python3
#
# [219] 存在重复元素 II
#

# @lc code=start


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        dict = {}
        for i, num in enumerate(nums):
            if num in dict and i - dict[num] <= k:
                return True
            else:
                dict[num] = i
        return False
# @lc code=end
