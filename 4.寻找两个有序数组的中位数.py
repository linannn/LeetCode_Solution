#
# @lc app=leetcode.cn id=4 lang=python3
#
# [4] 寻找两个有序数组的中位数
#

# @lc code=start
from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # 归并
        # i = 0
        # j = 0
        # li = []
        # while i < len(nums1) or j < len(nums2):
        #     if j >= len(nums2) or i < len(nums1) and \
        #             j < len(nums2) and nums1[i] <= nums2[j]:
        #         li.append(nums1[i])
        #         i += 1
        #     else:
        #         li.append(nums2[j])
        #         j += 1
        # if len(li) % 2 == 0:
        #     return (li[len(li) // 2 - 1] + li[len(li) // 2]) / 2
        # else:
        #     return li[len(li) // 2]
        def he(nums1, start1, end1, nums2, start2, end2, k):
            len1 = end1 - start1 + 1
            len2 = end2 - start2 + 1
            if len1 > len2:
                return he(nums2, start2, end2, nums1, start1, end1, k)
            if len1 == 0:
                return nums2[start2+k-1]
            if k == 1:
                return min(nums1[start1], nums2[start2])
            i = start1 + min(len1, k // 2) - 1
            j = start2 + min(len2, k // 2) - 1
            if nums1[i] > nums2[j]:
                return he(nums1, start1, end1, nums2, j+1, end2, k-(j-start2+1))
            else:
                return he(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1))

        n = len(nums1)
        m = len(nums2)
        left = (n + m + 1) // 2
        right = (n + m + 2) // 2
        return (he(nums1, 0, n-1, nums2, 0, m-1, left)+he(nums1, 0, n-1, nums2, 0, m-1, right))/2


# public double findMedianSortedArrays(int[] nums1, int[] nums2) {
#     int n = nums1.length
#     int m = nums2.length
#     int left = (n + m + 1) / 2
#     int right = (n + m + 2) / 2
#     return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5
# }

# private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
#     int len1 = end1 - start1 + 1
#     int len2 = end2 - start2 + 1
#     // 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
#     if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k)
#     if (len1 == 0) return nums2[start2 + k - 1]

#     if (k == 1) return Math.min(nums1[start1], nums2[start2])

#     int i = start1 + Math.min(len1, k / 2) - 1
#     int j = start2 + Math.min(len2, k / 2) - 1

#     if (nums1[i] > nums2[j]) {
#         return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1))
#     }
#     else {
#         return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1))
#     }
# }
# @lc code=end
