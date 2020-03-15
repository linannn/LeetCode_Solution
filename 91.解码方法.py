#
# @lc app=leetcode.cn id=91 lang=python3
#
# [91] 解码方法
#

# @lc code=start


class Solution:
    def numDecodings(self, s: str) -> int:
        if s[0] == '0':
            return 0
        last = 1
        cur = 1
        idx = 1
        while idx < len(s):
            tmp = cur
            if s[idx] == '0':
                if s[idx - 1] != '1' and s[idx - 1] != '2':
                    return 0
                else:
                    cur = last
            elif s[idx - 1] == '1' or (s[idx - 1] == '2' and '1' <= s[idx] <= '6'):
                cur = cur + last
            last = tmp
            idx += 1
        return cur
# @lc code=end
