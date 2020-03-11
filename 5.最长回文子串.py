#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#

# @lc code=start


class Solution:
    def longestPalindrome(self, s: str) -> str:
        # 动态规划 没看懂
        # size = len(s)
        # if size < 2:
        #     return s

        # dp = [[False for _ in range(size)] for _ in range(size)]

        # max_len = 1
        # start = 0

        # for i in range(size):
        #     dp[i][i] = True

        # for j in range(1, size):
        #     for i in range(0, j):
        #         if s[i] == s[j]:
        #             if j - i < 3:
        #                 dp[i][j] = True
        #             else:
        #                 dp[i][j] = dp[i + 1][j - 1]
        #         else:
        #             dp[i][j] = False

        #         if dp[i][j]:
        #             cur_len = j - i + 1
        #             if cur_len > max_len:
        #                 max_len = cur_len
        #                 start = i
        # return s[start:start + max_len]
        # 明白的动态规划
        # length = len(s)
        # if length < 2:
        #     return s
        # dp = [[False for _ in s] for __ in s]
        # max_len = 0
        # start = 0
        # for i in range(length):
        #     dp[i][i] = True
        # for i in range(length - 1):
        #     dp[i][i + 1] = s[i] == s[i + 1]

        # for i in range(1, length):
        #     for j in range(0, length - i):
        #         if s[j] == s[j+i]:
        #             if i > 1:
        #                 dp[j][j + i] = dp[j + 1][i + j - 1]
        #         if dp[j][j + i] and i > max_len:
        #             start = j
        #             max_len = i
        # return s[start:start+max_len+1]

        # 中心扩展算法
        length = len(s)
        if length < 2:
            return s
        start = 0
        end = 0

        def expend(left, right):
            while left >= 0 and right < length and s[left] == s[right]:
                left -= 1
                right += 1
            return right - left - 1

        for i in range(length):
            l1 = expend(i, i)
            l2 = expend(i, i + 1)
            l = max(l1, l2)
            if l > end - start:
                start = i - (l - 1) // 2
                end = i + l // 2
        return s[start:end+1]
# @lc code=end
