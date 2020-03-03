#
# @lc app=leetcode.cn id=229 lang=python3
#
# [229] 求众数 II
#

# @lc code=start


class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        candi_a = None
        candi_b = None
        count_a = 0
        count_b = 0
        for i in nums:
            if i == candi_a:
                count_a += 1
                continue
            if i == candi_b:
                count_b += 1
                continue
            if count_a == 0:
                candi_a = i
                count_a += 1
                continue
            if count_b == 0:
                candi_b = i
                count_b += 1
                continue
            count_a -= 1
            count_b -= 1
        count_a = 0
        count_b = 0
        for i in nums:
            if i == candi_a:
                count_a += 1
            if i == candi_b:
                count_b += 1
        res = []
        if count_a > len(nums) // 3:
            res.append(candi_a)
        if count_b > len(nums) // 3:
            res.append(candi_b)
        return res


# @lc code=end
