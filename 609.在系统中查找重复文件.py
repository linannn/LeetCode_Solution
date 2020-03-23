#
# @lc app=leetcode.cn id=609 lang=python3
#
# [609] 在系统中查找重复文件
#

# @lc code=start
from collections import defaultdict
from typing import List


class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        dict = defaultdict(list)
        for pathss in paths:
            tmp = pathss.split(' ')
            path = tmp[0]
            names = tmp[1:]
            for name_content in names:
                tmpp = name_content.split('(')
                name = tmpp[0]
                content = tmpp[1][:-1]
                dict[content].append(path + '/' + name)

        return [dict[k] for k in dict if len(dict[k]) > 1]

# @lc code=end
