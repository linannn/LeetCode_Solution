#
# @lc app=leetcode.cn id=9 lang=python3
#
# [9] 回文数
#

# @lc code=start


class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        li = []
        ori = x
        while x > 0:
            x, div = divmod(x, 10)
            li.append(div)
        res = 0
        for i in li:
            res = res * 10 + i
        return res == ori
# @lc code=end
