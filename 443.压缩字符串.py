#
# @lc app=leetcode.cn id=443 lang=python3
#
# [443] 压缩字符串
#

# @lc code=start
from typing import List


class Solution:
    def compress(self, chars: List[str]) -> int:
        # 我的
        # if len(chars) <= 1:
        #     return len(chars)
        # res = []
        # last = chars[0]
        # num = 1
        # for i in range(1, len(chars)):
        #     if chars[i] == last:
        #         num += 1
        #     else:
        #         res.append(last)
        #         if num > 1:
        #             res.extend(list(str(num)))
        #         last = chars[i]
        #         num = 1
        # res.append(last)
        # if num > 1:
        #     res.extend(list(str(num)))
        # for i in range(len(res)):
        #     chars[i] = res[i]
        # return len(res)

        anchor = write = 0
        for read, c in enumerate(chars):
            if read + 1 == len(chars) or chars[read + 1] != c:
                chars[write] = chars[anchor]
                write += 1
                if read > anchor:
                    for digit in str(read - anchor + 1):
                        chars[write] = digit
                        write += 1
                anchor = read + 1
        return write

# @lc code=end
