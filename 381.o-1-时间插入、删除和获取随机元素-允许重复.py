#
# @lc app=leetcode.cn id=381 lang=python3
#
# [381] O(1) 时间插入、删除和获取随机元素 - 允许重复
#

# @lc code=start
from collections import defaultdict
from random import choice


class RandomizedCollection:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list = []
        self.dict = defaultdict(set)

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
        """
        self.dict[val].add(len(self.list))
        self.list.append(val)
        return len(self.dict[val]) == 1

    def remove(self, val: int) -> bool:
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        """
        if val not in self.dict:
            return False
        idx = self.dict[val].pop()
        last_val = self.list[-1]
        self.dict[last_val].add(idx)
        self.dict[last_val].remove(len(self.list) - 1)
        self.list[idx] = last_val
        self.list.pop()
        if len(self.dict[val]) == 0:
            del self.dict[val]
        return True

    def getRandom(self) -> int:
        """
        Get a random element from the collection.
        """
        if (len(self.list) == 0):
            return None
        return choice(self.list)


# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
# @lc code=end
