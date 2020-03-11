#
# @lc app=leetcode.cn id=8 lang=python3
#
# [8] 字符串转换整数 (atoi)
#

# @lc code=start

import re


class Solution:
    def myAtoi(self, str: str) -> int:
        # 我的
        # MAX = 2147483647
        # MIN = -2147483648
        # flags = {'+', '-'}
        # read_flag = True
        # stack = []
        # for ch in str:
        #     if read_flag:
        #         if ch == ' ':
        #             continue
        #         if ch in flags or ch.isdigit():
        #             stack.append(ch)
        #             read_flag = False
        #         else:
        #             return 0
        #     else:
        #         if ch.isdigit():
        #             stack.append(ch)
        #         else:
        #             break
        # wei = 0
        # res = 0
        # while stack:
        #     ch = stack.pop()
        #     if ch.isdigit():
        #         res += int(ch) * 10 ** wei
        #         wei += 1
        #     elif ch == '-':
        #         res = -res
        # res = MAX if res > MAX else res
        # res = MIN if res < MIN else res

        # return res
        MAX = 2147483647
        MIN = -2147483648
        str = str.lstrip()
        num_re = re.compile(r'^[\+\-]?\d+')
        res = num_re.findall(str)  # 查找匹配的内容
        res = int(*res)  # 由于返回的是个列表，解包并且转换成整数
        return max(min(res, MAX), MIN)  # 返回值)

# @lc code=end
