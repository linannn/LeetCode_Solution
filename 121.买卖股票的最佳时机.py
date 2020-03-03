#
# @lc app=leetcode.cn id=121 lang=python3
#
# [121] 买卖股票的最佳时机
#

# @lc code=start


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_value = float('inf')
        _max = 0
        for i in range(len(prices)):
            if (prices[i] < min_value):
                min_value = prices[i]
            if (prices[i] - min_value > _max):
                _max = prices[i] - min_value
            pass
        return _max
# @lc code=end
