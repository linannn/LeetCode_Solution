#
# @lc app=leetcode.cn id=13 lang=python3
#
# [13] 罗马数字转整数
#

# @lc code=start


class Solution:
    def romanToInt(self, s: str) -> int:
        nums = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        romans = ["M", "CM", "D", "CD", "C", "XC",
                  "L", "XL", "X", "IX", "V", "IV", "I"]
        res = 0
        index = 0
        num_index = 0
        while index < len(s):
            while num_index < len(nums):
                while s[index:].startswith(romans[num_index]):
                    index += len(romans[num_index])
                    res += nums[num_index]
                num_index += 1
        return res
# @lc code=end
