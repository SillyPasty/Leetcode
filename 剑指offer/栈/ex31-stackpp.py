class Solution:
    def validateStackSequences(self, pushed, popped):
        if not pushed:
            return True
        stack = []
        idxPu = 0
        idxPo = 0
        while idxPu < len(pushed) or (stack and stack[-1] == popped[idxPo]):
            if idxPu < len(pushed) and pushed[idxPu] == popped[idxPo]:
                idxPo += 1
                idxPu += 1
            elif stack and stack[-1] == popped[idxPo]:
                stack.pop()
                idxPo += 1
            else:
                stack += [pushed[idxPu]]
                idxPu += 1
        return idxPo == len(popped)

def main():
    sol = Solution()
    pushed = [1,2,3,4,5]
    popped = [4,3,5,1,2]
    print(sol.validateStackSequences(pushed, popped))

main()