#
# @lc app=leetcode.cn id=670 lang=python3
#
# [670] 最大交换
#

# @lc code=start


class Solution:
    def maximumSwap(self, num: int) -> int:
        num_str = str(num)
        digit_last_index = [None for _ in range(10)]

        # 统计每个数字出现的最后的位置
        for i, digit in enumerate(num_str):
            digit_last_index[int(digit)] = i

        for i, digit in enumerate(num_str):
            # 从最低位开始寻找
            for index in range(9, int(digit), -1):
                if digit_last_index[index] != None and digit_last_index[index] > i:
                    # digit_last_index[index] 和 i 位置的元素交换(字符串不能修改太坑了...)
                    return num_str[: i] + num_str[digit_last_index[index]] + num_str[i + 1: digit_last_index[index]] + num_str[i] + num_str[digit_last_index[index] + 1:]
        # 已是最大值就返回原数字
        return num
# @lc code=end
