#
# @lc app=leetcode.cn id=7 lang=python3
#
# [7] 整数反转
#

# @lc code=start


class Solution:
    def reverse(self, x: int) -> int:
        # 字符串偷鸡
        # flag = True
        # if x < 0:
        #     flag = False
        # x = abs(x)
        # tmp = int(''.join(list(str(x))[::-1]))
        # tmp = -tmp if not flag else tmp
        # if - 2 ** 31 <= tmp <= 2 ** 31 - 1:
        #     return tmp
        # return 0
        flag = True if x > 0 else False
        x = abs(x)
        li = []
        while x > 0:
            x, div = divmod(x, 10)
            li.append(div)
        res = 0
        for i in li:
            res = res*10 + i
        if not flag:
            res = -res
        if - 2 ** 31 <= res <= 2 ** 31 - 1:
            return res
        return 0
# @lc code=end
