#
# @lc app=leetcode.cn id=674 lang=python3
#
# [674] 最长连续递增序列
#

# @lc code=start


class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)
        res = 1
        tmp = [nums[0]]
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                tmp.append(nums[i])
            else:
                if len(tmp) > res:
                    res = len(tmp)
                tmp = [nums[i]]
            if i == len(nums)-1 and len(tmp) > res:
                res = len(tmp)
        return res


# @lc code=end
