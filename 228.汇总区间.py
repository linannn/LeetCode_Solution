#
# @lc app=leetcode.cn id=228 lang=python3
#
# [228] 汇总区间
#

# @lc code=start


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        res = []
        i = 0
        while i < len(nums):
            tmp = str(nums[i])
            last = i
            while i < len(nums) - 1 and nums[i] == nums[i+1]-1:
                i += 1
            if last != i:
                tmp += '->'+str(nums[i])
            res.append(tmp)
            i += 1
        return res

# @lc code=end
