#
# @lc app=leetcode.cn id=643 lang=python3
#
# [643] 子数组最大平均数 I
#

# @lc code=start


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        length = len(nums)
        if length < k:
            return sum(nums) / length
        _sum = sum(nums[:k])
        avg = _sum/k
        for i in range(1, len(nums) - k+1):
            _sum = _sum - nums[i - 1] + nums[i + k - 1]
            avg = max(avg, _sum / k)
        return avg


# @lc code=end
