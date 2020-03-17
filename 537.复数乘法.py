#
# @lc app=leetcode.cn id=537 lang=python3
#
# [537] 复数乘法
#

# @lc code=start


class Solution:
    def complexNumberMultiply(self, a: str, b: str) -> str:
        def parse(s: str):
            li = s.split('+')
            # li = list(filter(lambda item: len(item) > 0, li))
            # if len(li) == 2:
            li[0] = int(li[0])
            li[1] = int(li[1][:-1])
            # else:
            #     if s[-1] == 'i':
            #         li.append(int(li[0][:-1]))
            #         li[0] = 0
            #     else:
            #         li[0] = int(li[0])
            #         li[1] = 0
            return li
        a = parse(a)
        b = parse(b)
        return '{}+{}i'.format(a[0]*b[0]-a[1]*b[1], a[0]*b[1]+a[1]*b[0])

# @lc code=end
