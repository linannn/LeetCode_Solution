#
# @lc app=leetcode.cn id=717 lang=python3
#
# [717] 1比特与2比特字符
#

# @lc code=start

from typing import List


class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        if len(bits) == 0:
            return False
        if bits[-1] != 0:
            return False

        def match(idx):
            if idx == 0:
                if bits[idx] == 0:
                    return True
            if idx < 0:
                return True

            if bits[idx] == 1:
                if bits[idx - 1] == 0:
                    return False
                return match(idx-2)
            else:
                if bits[idx - 1] == 1:
                    if match(idx - 2):
                        return True
                return match(idx - 1)

        return match(len(bits)-2)

# @lc code=end
