#
# @lc app=leetcode.cn id=165 lang=python3
#
# [165] 比较版本号
#

# @lc code=start


class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        # 1
        v1_arr = version1.split('.')
        v2_arr = version2.split('.')
        min_len = min(len(v1_arr), len(v2_arr))

        for i in range(min_len):
            v1 = int(v1_arr[i])
            v2 = int(v2_arr[i])
            if v1 > v2:
                return 1
            if v1 < v2:
                return - 1
        i += 1
        v1_idx, v2_idx = i, i
        while len(v1_arr) - v1_idx > 0 and int(v1_arr[v1_idx]) == 0:
            v1_idx += 1
        while len(v2_arr) - v2_idx > 0 and int(v2_arr[v2_idx]) == 0:
            v2_idx += 1

        if len(v1_arr)-v1_idx == len(v2_arr)-v2_idx:
            return 0
        return 1 if len(v1_arr) > len(v2_arr) else - 1
        # 2
        # v1_arr = version1.split('.')
        # v2_arr = version2.split('.')
        # l1 = len(v1_arr)
        # l2 = len(v2_arr)
        # if l1 > l2:
        #     tmp = l1 - l2
        #     while tmp:
        #         v2_arr.append('0')
        #         tmp -= 1
        # if l1 < l2:
        #     tmp = l2 - l1
        #     while tmp:
        #         v1_arr.append('0')
        #         tmp -= 1

        # for i in range(len(v1_arr)):
        #     v1 = int(v1_arr[i])
        #     v2 = int(v2_arr[i])
        #     if v1 > v2:
        #         return 1
        #     if v1 < v2:
        #         return - 1
        # return 0
# @lc code=end
