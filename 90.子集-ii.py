#
# @lc app=leetcode.cn id=90 lang=python3
#
# [90] 子集 II
#

# @lc code=start


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()

        def get_ans(start, tmp):
            res.append(tmp+[])
            for i in range(start, len(nums)):
                if i > start and nums[i] == nums[i - 1]:
                    continue
                tmp.append(nums[i])
                get_ans(i+1, tmp)
                tmp.pop()
        get_ans(0, [])
        return res

# @lc code=end
