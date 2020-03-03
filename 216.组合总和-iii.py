#
# @lc app=leetcode.cn id=216 lang=python3
#
# [216] 组合总和 III
#

# @lc code=start


class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        res = []

        def gene_next(nums, start, level):
            if level <= 0:
                return
            for i in range(start, 10):
                _sum = sum(nums) + i
                if _sum < n:
                    gene_next(nums + [i], i+1, level - 1)
                if _sum == n and level == 1:
                    res.append(nums + [i])
                if _sum > n:
                    break
        gene_next([], 1, k)
        return res
# @lc code=end
