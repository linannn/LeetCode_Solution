#
# @lc app=leetcode.cn id=722 lang=python3
#
# [722] 删除注释
#

# @lc code=start
from typing import List


class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        in_comment = False
        for i in range(len(source)):
            line = source[i]
            start = 0
            while start < len(line) and line[start] == ' ':
                start += 1
            if line[start:].startswith('//'):
                source[i] = line[:start]
                continue
            in_str = False
            for i in range(start, len(line)):
                if line[i] == '"' and i > 1 and line[i - 1] != '/' and not in_comment:
                    in_str = not in_str
                    start += 1
                elif line[i] == '/' and i + 1 < len(line) and\
                        line[i + 1] == '*' and not in_str and not in_comment:
                    in_comment = True


# @lc code=end
