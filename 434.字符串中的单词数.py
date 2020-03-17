#
# @lc app=leetcode.cn id=434 lang=python3
#
# [434] 字符串中的单词数
#

# @lc code=start


class Solution:
    def countSegments(self, s: str) -> int:
        # ss = s.split(" ")
        # num = 0
        # for i in ss:
        #     if i == '':
        #         continue
        #     num += 1
        # return num
        segment_count = 0

        for i in range(len(s)):
            if (i == 0 or s[i-1] == ' ') and s[i] != ' ':
                segment_count += 1

        return segment_count

# @lc code=end
