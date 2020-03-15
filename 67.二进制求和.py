#
# @lc app=leetcode.cn id=67 lang=python3
#
# [67] 二进制求和
#

# @lc code=start


class Solution:
    def addBinary(self, a: str, b: str) -> str:
        # 我的
        # res = ''
        # if len(a) < len(b):
        #     a, b = b, a
        # next_ = 0
        # for i in range(len(a)):
        #     ia = int(a[len(a)-i-1])
        #     if i < len(b):
        #         ib = int(b[len(b)-1-i])
        #     else:
        #         ib = 0
        #     next_, cur = divmod(ia+ib+next_, 2)
        #     res = str(cur) + res
        # if next_ == 1:
        #     res = '1' + res
        # return res
        # 转化
        # return bin(int(a, 2) + int(b, 2)).replace('0b', '')

        # 位运算
        a = int(a, 2)
        b = int(b, 2)
        while b:
            res = a ^ b
            carry = (a & b) << 1
            a, b = res, carry
        return '{:b}'.format(a)

# @lc code=end
