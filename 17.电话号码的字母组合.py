#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#

# @lc code=start
from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        # 我的
        # dict = [[], [], ['a', 'b', 'c'], ['d', 'e', 'f'],
        #         ['g', 'h', 'i'], ['j', 'k', 'l'], ['m', 'n', 'o'],
        #         ['p', 'q', 'r', 's'], ['t', 'u', 'v'],
        #         ['w', 'x', 'y', 'z']]
        # if digits == '':
        #     return []
        # res = ['']
        # res_tmp = []
        # for num in digits:
        #     res_tmp = []
        #     for ch in dict[int(num)]:
        #         for com in res:
        #             res_tmp.append(com + ch)
        #     res = res_tmp
        # return res

        dict = [[], [], ['a', 'b', 'c'], ['d', 'e', 'f'],
                ['g', 'h', 'i'], ['j', 'k', 'l'], ['m', 'n', 'o'],
                ['p', 'q', 'r', 's'], ['t', 'u', 'v'],
                ['w', 'x', 'y', 'z']]

        def backtrack(combination, next_digits):
            # if there is no more digits to check
            if len(next_digits) == 0:
                # the combination is done
                res.append(combination)
            # if there are still digits to check
            else:
                # iterate over all letters which map
                # the next available digit
                for letter in dict[int(next_digits[0])]:
                    # append the current letter to the combination
                    # and proceed to the next digits
                    backtrack(combination + letter, next_digits[1:])
        res = []
        if digits:
            backtrack("", digits)
        return res
# @lc code=end
