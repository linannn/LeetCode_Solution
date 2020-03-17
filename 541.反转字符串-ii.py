#
# @lc app=leetcode.cn id=541 lang=python3
#
# [541] 反转字符串 II
#

# @lc code=start


class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        # 我的
        # if k == 1:
        #     return s
        # idx = 0
        # s = list(s)
        # while idx * k < len(s):
        #     i = idx * k
        #     j = min(idx * k + k - 1, len(s) - 1)
        #     s[i:j+1] = reversed(s[i:j+1])
        #     # while i < j:
        #     #     s[i], s[j] = s[j], s[i]
        #     #     i += 1
        #     #     j -= 1
        #     idx += 2
        # return ''.join(s)
        a = list(s)
        for i in range(0, len(a), 2 * k):
            a[i:i + k] = reversed(a[i:i + k])
        return ''.join(a)
# @lc code=end
