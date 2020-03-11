#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] 无重复字符的最长子串
#

# @lc code=start

# from collections import deque


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # 使用双端队列模拟滑动窗口
        # res = 0
        # char_set = deque()
        # for i in s:
        #     if i not in char_set:
        #         char_set.append(i)
        #     else:
        #         res = max(res, len(char_set))
        #         char_set.append(i)
        #         while char_set.popleft() != i:
        #             pass
        # return max(res, len(char_set))

        # 使用hash模拟滑动窗口
        res = 0
        char_set = set()
        j = 0
        for i in s:
            if i not in char_set:
                char_set.add(i)
            else:
                res = max(res, len(char_set))
                while i in char_set:
                    char_set.remove(s[j])
                    j += 1
                char_set.add(i)
        return max(res, len(char_set))

# @lc code=end
