class Solution:
    def findContinuousSequence(self, target: int):
        left = 1
        right = 2
        res = []
        while left < right and right < target:
            sums = ((left + right) * (right - left + 1)) // 2
            if sums == target:
                lis = [x for x in range(left, right+1)]
                res.append(lis)
                left += 1
                right += 1
            elif sums < target:
                right += 1
            else:
                left += 1
        return res

def main():
    sol = Solution()
    print(sol.findContinuousSequence(5))

main()