#
# @lc app=leetcode.cn id=605 lang=python3
#
# [605] 种花问题
#

# @lc code=start


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        flowerbed = [0] + flowerbed + [0]
        for i in range(1, len(flowerbed) - 1):
            if flowerbed[i] == 0 == flowerbed[i - 1] == flowerbed[i + 1]:
                flowerbed[i] = 1
                n -= 1
        return n <= 0
# @lc code=end
