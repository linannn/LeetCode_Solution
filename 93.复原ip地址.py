#
# @lc app=leetcode.cn id=93 lang=python3
#
# [93] 复原IP地址
#

# @lc code=start
from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        length = len(s)

        def back(li: List, start, end, depth):
            if start > length - 1:
                return
            # li = li + []
            if depth == 3:
                if int(s[start:]) <= 255:
                    if start < length - 1 and s[start] == '0':
                        return
                    li.append(s[start:])
                    res.append('.'.join(li))
                    li.pop()
                return
            else:
                if end > length or int(s[start:end]) > 255:
                    return
                li.append(s[start:end])
                back(li, end, end+1, depth+1)
                li.pop()
                if s[start] != '0':
                    back(li, start, end + 1, depth)
        back([], 0, 1, 0)
        return res

# @lc code=end
