#
# @lc app=leetcode.cn id=565 lang=python3
#
# [565] 数组嵌套
#

# @lc code=start


class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        res = 0
        for i in range(len(nums)):
            if nums[i] < 0:
                continue
            idx = nums[i]
            count = 0
            while nums[idx] >= 0:
                tmp = idx
                idx = nums[idx]
                count += 1
                nums[tmp] = -1
            res = max(count, res)
        return res
# @lc code=end
