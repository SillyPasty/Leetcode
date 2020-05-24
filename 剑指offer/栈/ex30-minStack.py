# 记得加SELF！！
# 审题！
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.minStack = []
        self.stack = []


    def push(self, x: int) -> None:
        if not self.stack:
            self.stack += [x]
            self.minStack += [x]
        else:
            self.stack += [x]
            self.minStack += [x] if x < self.minStack[-1] else [self.minStack[-1]]
        

    def pop(self) -> None:
        if not self.stack:
            return
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        if not self.stack:
            return self.stack
        return self.stack[-1]

    def min(self) -> int:
        if not self.minStack:
            return self.minStack
        return self.minStack[-1]