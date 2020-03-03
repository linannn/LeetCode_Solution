#
# @lc app=leetcode.cn id=621 lang=python3
#
# [621] 任务调度器
#

# @lc code=start
from collections import Counter


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        co = Counter(tasks)
        tongji = sorted(co.items(), key=lambda x: x[1], reverse=True)
        max_nums = tongji[0][1]
        others = 0
        for j in tongji:
            if j[1] == max_nums:
                others += 1
        return max(len(tasks), (max_nums-1)*(n+1)+others)

# @lc code=end
