#
# @lc app=leetcode.cn id=202 lang=python3
#
# [202] 快乐数
#

# @lc code=start


class Solution:
    def isHappy(self, n: int) -> bool:
        def h(num):
            if num == 1:
                return True
            if num in s:
                return False
            s.add(num)
            new_num = 0
            li = list(str(num))
            for i in li:
                new_num += int(i)**2
            return h(new_num)
        s = set()
        return h(n)

# @lc code=end
