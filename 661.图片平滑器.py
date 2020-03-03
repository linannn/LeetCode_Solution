#
# @lc app=leetcode.cn id=661 lang=python3
#
# [661] 图片平滑器
#

# @lc code=start


class Solution:
    def imageSmoother(self, M: List[List[int]]) -> List[List[int]]:
        tmp = []
        tmp.append([0 for i in range(len(M[0])+2)])
        for i in M:
            tmp.append([0]+i+[0])
        tmp.append([0 for i in range(len(M[0])+2)])
        res = []
        for i in range(1, len(M)+1):
            row_res = []
            for j in range(1, len(M[0])+1):
                col_num = min(j+1, len(M[0]))-max(1, j-1)+1
                row_num = min(i+1, len(M))-max(1, i-1)+1
                row_res.append((tmp[i - 1][j - 1] + tmp[i - 1][j] + tmp[i - 1][j + 1]
                                + tmp[i][j - 1] + tmp[i][j] + tmp[i][j + 1] +
                                tmp[i + 1][j - 1] + tmp[i + 1][j] + tmp[i + 1][j + 1])
                               // (row_num*col_num))
            res.append(row_res)
        return res
        # @lc code=end
