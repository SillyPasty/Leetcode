class Solution:
    def twoSum(self, n):
        maxNum = 6
        lis = [0 for i in range(maxNum * n + 1)]
        for i in range(1, maxNum + 1):
            lis[i] = 1
        for i in range(2, n + 1):
            newL = [0 for i in range(maxNum * n + 1)]
            for j in range(i, i*maxNum + 1):
                for k in range(1, maxNum + 1):
                    if j - k < 1:
                        break
                    newL[j] += lis[j - k]
            lis = newL[:]
        result = []
        total = maxNum ** n
        print(lis)
        for i in range(n, maxNum * n + 1):
            result.append(lis[i] / total)
        return result

def main():
    n = 3
    sol = Solution()
    print(sol.twoSum(n))

main()