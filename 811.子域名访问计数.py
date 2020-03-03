#
# @lc app=leetcode.cn id=811 lang=python3
#
# [811] 子域名访问计数
#

# @lc code=start
from collections import defaultdict
from typing import List


class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        res = []
        dict = defaultdict(int)

        def combDomain(domain_list):
            domains = []
            d = domain_list[-1]
            domains.append(d)
            for i in range(len(domain_list) - 2, -1, -1):
                d = domain_list[i] + '.' + d
                domains.append(d)
            return domains
        for domain_info in cpdomains:
            tmp = domain_info.split(' ')
            access_num = int(tmp[0])
            domains = combDomain(tmp[1].split('.'))
            for domain in domains:
                dict[domain] += access_num
        for i in dict.keys():
            res.append('{} {}'.format(dict[i], i))
        return res
# @lc code=end
