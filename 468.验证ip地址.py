#
# @lc app=leetcode.cn id=468 lang=python3
#
# [468] 验证IP地址
#

# @lc code=start
from typing import List
from ipaddress import ip_address, IPv6Address


class Solution:
    def __init__(self):
        tmp = 'abcdef'
        self.jinzhi = set(tmp)
        self.jinzhi.update(list(tmp.upper()))

    def validIPAddress(self, IP: str) -> str:
        if self.ipv4(IP):
            return "IPv4"
        if self.ipv6(IP):
            return "IPv6"
        return 'Neither'

    def ipv4(self, ip: str) -> bool:
        li = ip.split(".")
        if len(li) != 4:
            return False
        for s in li:
            if not s.isdigit():
                return False
            if int(s) > 255:
                return False
            if len(s) > 1 and s[0] == '0':
                return False
        return True

    def ipv6(self, ip: str) -> bool:
        li = ip.split(":")
        if len(li) != 8:
            return False
        for s in li:
            for ch in s:
                if not ch.isdigit() and ch not in self.jinzhi:
                    return False
            if len(s) > 4 or len(s) == 0:
                return False
        return True
# @lc code=end
