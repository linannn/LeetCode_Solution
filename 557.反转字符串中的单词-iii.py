#
# @lc app=leetcode.cn id=557 lang=python3
#
# [557] 反转字符串中的单词 III
#

# @lc code=start


class Solution:
    def reverseWords(self, s: str) -> str:
        li = s.split(' ')
        for i in range(len(li)):
            li[i] = li[i][::-1]
        return ' '.join(li)

# @lc code=end
