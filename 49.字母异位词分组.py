#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start
from collections import defaultdict
from typing import List
from collections import Counter


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 计数
        # dict = defaultdict(list)
        # for s in strs:
        #     count = Counter(s)
        #     li = sorted(count.items(), key=lambda item: item[0])
        #     tmp = tuple(li)
        #     dict[tmp].append(s)
        # return [dict[i] for i in dict.keys()]
        # 排序
        dict = defaultdict(list)
        for s in strs:
            dict[tuple(sorted(s))].append(s)
        return [dict[i] for i in dict.keys()]

# @lc code=end
