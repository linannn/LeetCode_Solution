#
# @lc app=leetcode.cn id=385 lang=python3
#
# [385] 迷你语法分析器
#

# @lc code=start
# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
# class NestedInteger:
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """


class Solution:
    def __init__(self):
        self.chars = []
        self.cur = 0

    def deserialize(self, s: str) -> NestedInteger:
        self.chars = list(s)
        self.cur = 0
        if s[0] != '[':
            return NestedInteger(int(s))
        return self.getNest()

    def getNest(self):
        nest = NestedInteger()
        num = 0
        flag = False
        while self.cur < len(self.chars):
            self.cur += 1
            if self.chars[self.cur] == ',':
                continue
            if self.chars[self.cur] == '[':
                nest.add(self.getNest())
            elif self.chars[self.cur] == ']':
                return nest
            elif self.chars[self.cur] == '-':
                flag = True
            else:
                if not flag:
                    num = num*10-(ord(self.chars[self.cur])-48)
                else:
                    num = num*10+(ord(self.chars[self.cur])-48)
                if self.chars[self.cur] == ',' or self.chars[self.cur] == ']':
                    nest.add(NestedInteger(num))
                    num = 0
                    flag = False
        return nest
# @lc code=end
