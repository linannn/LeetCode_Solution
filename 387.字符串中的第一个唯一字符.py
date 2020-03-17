#
# @lc app=leetcode.cn id=387 lang=python3
#
# [387] 字符串中的第一个唯一字符
#

# @lc code=start
from collections import Counter
# from collections import defaultdict
# from collections import OrderedDict


class Solution:
    def firstUniqChar(self, s: str) -> int:
        # 1
        # counter = Counter(s)
        # m = len(s) + 1
        # if m == 1:
        #     return -1
        # min_ch = s[-1]
        # for ch in counter:
        #     if counter[ch] == 1:
        #         min_ch = ch
        #         m = min(m, s.index(min_ch))
        # return -1 if m == len(s) + 1 else m
        # 2
        # d = OrderedDict()
        # for ch in s:
        #     if ch not in d:
        #         d[ch] = 0
        #     d[ch] += 1
        # for ch in d:
        #     if d[ch] == 1:
        #         return s.find(ch)
        # return -1
        # 3
        counter = Counter(s)
        for i, ch in enumerate(s):
            if counter[ch] == 1:
                return i
        return -1
# @lc code=end
