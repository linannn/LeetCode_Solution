#
# @lc app=leetcode.cn id=415 lang=python3
#
# [415] 字符串相加
#

# @lc code=start


class Solution:
    def addStrings(self, num1: str, num2: str) -> str:

        if len(num1) < len(num2):
            num1, num2 = num2, num1
        carry = 0
        res = ''
        for i in range(len(num1)):
            n1 = int(num1[len(num1)-i-1])
            n2 = int(num2[len(num2)-i-1]) if i < len(num2) else 0
            carry, tmp = divmod(n1+n2+carry, 10)
            res = str(tmp) + res
        if carry == 1:
            res = '1'+res
        return res


# @lc code=end
