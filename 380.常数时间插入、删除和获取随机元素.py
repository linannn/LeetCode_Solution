#
# @lc app=leetcode.cn id=380 lang=python3
#
# [380] 常数时间插入、删除和获取随机元素
#

# @lc code=start

from random import choice


class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dict = {}
        self.list = []

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val in self.dict:
            return False
        self.list.append(val)
        self.dict[val] = len(self.list)-1
        return True

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.dict:
            return False
        idx = self.dict[val]
        last_val = self.list[-1]
        self.list[idx] = last_val
        self.dict[last_val] = idx
        self.list.pop()
        # 不能放到前面，如果数组只剩最后一个元素会再次加入
        del self.dict[val]
        return True

    def getRandom(self) -> int:
        """
            Get a random element from the set.
            """
        return choice(self.list)

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
# @lc code=end
