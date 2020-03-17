#
# @lc app=leetcode.cn id=520 lang=python3
#
# [520] 检测大写字母
#

# @lc code=start


class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        daxie = 0
        for ch in word:
            if ch.isupper():
                daxie += 1
        return daxie == 0 or daxie == len(word) or daxie == 1 and word[0].isupper()

# @lc code=end
