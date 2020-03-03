#
# @lc app=leetcode.cn id=457 lang=python3
#
# [457] 环形数组循环
#

# @lc code=start


class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        path_set = set()
        length = len(nums)
        i = 0
        flag = [0 for _ in nums]
        while i < length:
            if flag[i] == 0:
                path_set.clear()
                path_set.add(i)
                flag[i] = nums[i]/abs(nums[i])
                idx = (i + nums[i]) % length
                last_index = i
                while flag[idx] == 0:
                    if nums[idx] * flag[last_index] < 0:
                        break
                    path_set.add(idx)
                    flag[idx] = nums[i]/abs(nums[i])
                    last_index = idx
                    idx += nums[idx]
                    idx %= length
                if idx in path_set and idx != last_index and nums[idx] * flag[last_index] > 0:
                    return True
            i += 1
        return False
# @lc code=end
