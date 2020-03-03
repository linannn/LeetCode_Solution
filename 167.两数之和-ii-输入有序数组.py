#
# @lc app=leetcode.cn id=167 lang=python3
#
# [167] 两数之和 II - 输入有序数组
#

# @lc code=start


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        _map = {}
        for i in range(len(numbers)):
            if numbers[i] in _map:
                return [min(i+1, _map[numbers[i]]), max(i+1, _map[numbers[i]])]
            else:
                _map[target-numbers[i]] = i+1
# @lc code=end
