#
# @lc app=leetcode.cn id=155 lang=python3
#
# [155] 最小栈
#

# @lc code=start


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.li = []
        self.helper = []

    def push(self, x: int) -> None:
        self.li.append(x)
        if not self.helper or x <= self.helper[-1]:
            self.helper.append(x)
        # else:
        #     self.helper.append(self.helper[-1])

    def pop(self) -> None:
        tmp = self.li.pop()
        if self.helper and tmp == self.helper[-1]:
            self.helper.pop()

    def top(self) -> int:
        return self.li[-1]

    def getMin(self) -> int:
        return self.helper[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# @lc code=end
