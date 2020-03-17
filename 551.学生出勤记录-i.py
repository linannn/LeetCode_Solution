#
# @lc app=leetcode.cn id=551 lang=python3
#
# [551] 学生出勤记录 I
#

# @lc code=start


class Solution:
    def checkRecord(self, s: str) -> bool:
        idx = s.find('A')
        if s.find('A', idx + 1) != -1 or s.find('LLL') != -1:
            return False
        return True
# @lc code=end
