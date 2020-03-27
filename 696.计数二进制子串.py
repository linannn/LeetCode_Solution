#
# @lc app=leetcode.cn id=696 lang=python3
#
# [696] 计数二进制子串
#

# @lc code=start


class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        # 我的
        # num = 0
        # find_strs = ['01', '10']
        # for temp in find_strs:
        #     start = 0
        #     mid_idx = s.find(temp, start)
        #     while mid_idx != -1:
        #         count = 1
        #         while count <= mid_idx and count + mid_idx + 1 < len(s) and \
        #                 s[mid_idx - count] == temp[0] and s[mid_idx + count+1] == temp[1]:
        #             count += 1
        #         num += count
        #         start = mid_idx + count
        #         mid_idx = s.find(temp, start)
        # return num
        graph = []
        last = s[0]
        count = 1
        for i in range(1, len(s)):
            print(s[i])
            if last == s[i]:
                count += 1
            else:
                graph.append(count)
                last = s[i]
                count = 1
        graph.append(count)
        res = 0
        for i in range(1, len(graph)):
            res += min(graph[i-1], graph[i])
        return res
# @lc code=end
