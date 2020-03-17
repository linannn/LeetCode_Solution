#
# @lc app=leetcode.cn id=383 lang=python3
#
# [383] 赎金信
#

# @lc code=start


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        # 我的
        # li = [0 for i in range(26)]
        # for ch in ransomNote:
        #     li[ord(ch) - 97] -= 1
        # for ch in magazine:
        #     li[ord(ch) - 97] += 1
        # for i in li:
        #     if i < 0:
        #         return False
        # return True
        li = [0] * 26
        for ch in ransomNote:
            idx = magazine.find(ch, li[ord(ch)-97])
            if idx == -1:
                return False
            li[ord(ch) - 97] = idx + 1
        return True

# @lc code=end
