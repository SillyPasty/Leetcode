class Solution:
    def translateNum(self, num: int) -> int:
        string = str(num)
        lis = [1, 1]
        for i in range(1, len(string) + 1):
            if i == 1:
                continue
            newS = string[len(string) - i] + string[len(string) - i + 1]
            if int(newS) < 26 and int(newS) >= 10:
                lis.append(lis[i - 1] + lis[i - 2])
            else:
                lis.append(lis[i - 1])
        return lis[len(string)]

def main():
    sol = Solution()
    nums = 10
    print(sol.translateNum(nums))

main()