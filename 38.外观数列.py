#
# @lc app=leetcode.cn id=38 lang=python3
#
# [38] 外观数列
#

# @lc code=start


class Solution:
    def countAndSay(self, n: int) -> str:
        # 我的
        def gene(s, depth):
            if depth == n:
                res.append(s)
                return
            length = len(s)
            idx = 1
            count = 1
            last = s[0]
            next_ = ''
            while idx < length:
                if s[idx] != last:
                    next_ += '{}{}'.format(count, last)
                    last = s[idx]
                    count = 1
                else:
                    count += 1
                idx += 1
            gene(next_ + '{}{}'.format(count, last), depth + 1)
        if n == 0:
            return ''
        res = []
        gene('1', 1)
        return res[0]

# @lc code=end
